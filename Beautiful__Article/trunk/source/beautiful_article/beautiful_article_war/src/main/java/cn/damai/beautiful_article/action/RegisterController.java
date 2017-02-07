package cn.damai.beautiful_article.action;

/**
 * Created by Administrator on 2016/10/11 0011.
 */

import cn.damai.beautiful_article.common.utils.DataResult;
import cn.damai.beautiful_article.common.utils.StringUtil;
import cn.damai.beautiful_article.common.utils.VerifyCodeUtil;
import cn.damai.beautiful_article.core.domain.Member;
import cn.damai.beautiful_article.core.myEnum.ResultCode;
import cn.damai.beautiful_article.core.redis.MemberDao;
import cn.damai.beautiful_article.core.service.UserService;
import cn.damai.beautiful_article.core.service.SystemLogService;
import cn.damai.beautiful_article.core.serviceutils.SMSUtils;
import cn.damai.beautiful_article.core.vo.UserRegisterLoginVo;
import cn.damai.beautiful_article.core.vo.UserVo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import java.util.Map;

import static cn.damai.beautiful_article.common.utils.VerifyCodeUtil.TYPE_ALL_MIXED;

@Controller
@RequestMapping("register")
public class RegisterController extends BaseController{

    private final static Logger logger = Logger.getLogger(RegisterController.class);

    private String account;

    @Resource
    private UserService userService;

    @Resource
    private  SMSUtils smsUtils;

    @Resource
    private SystemLogService systemLogService;

    @Resource
    private MemberDao memberDao;

    @RequestMapping("view")
    public ModelAndView view(Map<String, Object> context) {

        context.put("books", "books");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "xxx");
        modelAndView.setViewName("register");
        return modelAndView;
    }
    @RequestMapping("submit")
        public  @ResponseBody DataResult register(UserRegisterLoginVo userVo) {

        System.out.println(userVo);
        DataResult dataResult = new DataResult();
        //检查参数是否正确
         DataResult dataResult_check = checkUser(userVo);
        if(dataResult_check.getCode().equals(ResultCode.DEFAULT+"")){
            dataResult.setCode(ResultCode.DEFAULT.getValue()+"");
            dataResult.setMsg(dataResult_check.getMsg());
            return  dataResult;
        }
        int result=0;
       synchronized (this) {
           //检查是否已有该账户
           int count = userService.findCountByPhone(userVo.getUserPhone());
           if (count > 0) {
               dataResult.setCode(ResultCode.DEFAULT.getValue() + "");
               dataResult.setMsg("抱歉，该帐号已存在！");
               return dataResult;
           }
           //检查是否有相同的用户名
           int count2 = userService.findCountByUserName(userVo.getUserName());
           if (count2 > 0) {
               dataResult.setCode(ResultCode.DEFAULT.getValue() + "");
               dataResult.setMsg("该用户名已存在，请修改！");
           }

          result = userService.registerUser(userVo);
       }
        if (result > 0) {
            UserVo userVo1 = userService.findByPhone(userVo.getUserPhone());
            dataResult.setCode(ResultCode.SUCCESS.getValue()+"");
            dataResult.setMsg("恭喜您，注册成功！");
            dataResult.setData(userVo1);

            //清空注册使用的 图片验证码 和 手机验证码
            logger.info("清空注册使用的 图片验证码 和 手机验证码");
            request.getSession().setAttribute("verifyCode","");
            memberDao.delete(userVo.getUserPhone());

            //设置登陆状态的tag
            String loginkey = VerifyCodeUtil.generateTextCode(TYPE_ALL_MIXED,10,null);
            //memberDao.addObjectAndTime(loginkey,userVo,1800);
            Member member = new Member(userVo.getUserPhone(),loginkey);
            memberDao.addAndTime(member,3600);
            Cookie cookie = new Cookie(userVo.getUserPhone(),loginkey);
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
            logger.info("用户："+userVo.getUserPhone()+"  已登陆，登陆key为："+loginkey);
            System.out.println(memberDao.get(userVo.getUserPhone()));
        } else {
            dataResult.setCode(ResultCode.DEFAULT.getValue()+"");
            dataResult.setMsg("注册失败");
        }
        return dataResult;
    }

    /**
     *  获得手机验证码
     * @param userPhone 手机号
     * @param verifyCode  界面上的验证码
     * @return
     */
   @RequestMapping("getPhoneCode")
     public @ResponseBody DataResult getPhoneCode(String userPhone,String verifyCode){
       DataResult dataResult = new DataResult();
       // 验证验证码格式
       if(verifyCode==null||"".equals(verifyCode)||!StringUtil.isTrueString(verifyCode)){
           dataResult.setCode(ResultCode.DEFAULT.getValue()+"");
           dataResult.setMsg("验证码格式错误！");
           return dataResult;
       }
       //验证验证码是否与缓存中的相等
       if(null!=userPhone&&""!=userPhone&&StringUtil.isMobilePhoneNumber(userPhone)){
           String cacheCode = (String)request.getSession().getAttribute("verifyCode");
           if (cacheCode==null||!cacheCode.equals(verifyCode)){
               dataResult.setCode(ResultCode.DEFAULT.getValue()+"");
               dataResult.setMsg("验证码错误或已失效！");
               return dataResult;
           }
           /*//限制每个手机多少秒内不能获取手机验证码
           if(memberDao.get(userPhone)!=null){
               dataResult.setCode(ResultCode.DEFAULT.getValue()+"");
               dataResult.setMsg("120秒内不能获取手机验证码");
               return dataResult;
           }*/
           String ip  = getRemoteHost(request);
               if(memberDao.get(ip)!=null){
                   dataResult.setCode(ResultCode.DEFAULT.getValue()+"");
                   dataResult.setMsg("同一电脑在120内只能获取一次验证码");
                   return  dataResult;
               }
           String code ="";
           if(memberDao.get(userPhone)==null) {
               //生成手机验证码
                code = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY, 6, "");
           }else {
               code = memberDao.get(userPhone).getNickname();
           }
           //手机发送
           int tag = smsUtils.send(userPhone,code);
           if (tag==0){
               //短信发送成功
               dataResult.setCode(ResultCode.SUCCESS.getValue()+"");
               dataResult.setMsg("验证码已成功发送！");

               //将 （手机--验证码） 存入redis  作用： 防止同一手机多次验证码
               Member member = new Member();
               member.setId(userPhone);
               member.setNickname(code);
               memberDao.addAndTime(member,600);
               //将（ip--验证码） 存入rdis    作用：防止同一ip多次验证码
               Member member2 = new Member();
               member2.setId(ip);
               member2.setNickname(verifyCode);
               memberDao.addAndTime(member2, 120);
           }else{
               dataResult.setCode(ResultCode.DEFAULT.getValue()+"");
               dataResult.setMsg("验证码发送失败！");
           }
       }else {
           dataResult.setCode(ResultCode.DEFAULT.getValue()+"");
           dataResult.setMsg("手机格式不正确！");
       }

       return  dataResult;
   }


    private DataResult checkUser(UserRegisterLoginVo userVo){
        DataResult dataResult = new DataResult();
         dataResult.setCode(ResultCode.SUCCESS+"");
        if(StringUtil.isTrueString(userVo.getUserName())&&
                StringUtil.isTrueString(userVo.getUserPassword())&&
                StringUtil.isTrueString(userVo.getRePassword())&&
                StringUtil.isMobilePhoneNumber(userVo.getUserPhone())&&
                StringUtil.isTrueString(userVo.getVerifyCode())
               ){
            //假如邮箱不为空
            if (null!=userVo.getUserEmail()&&!userVo.getUserEmail().equals("")){
                if(!StringUtil.isEmailAddress(userVo.getUserEmail())){
                  dataResult.setCode(ResultCode.DEFAULT+"");
                    dataResult.setMsg("邮件格式有误");
                    return dataResult;
                }
            }
        }else{
             dataResult.setCode(ResultCode.DEFAULT+"");
             dataResult.setMsg("填写信息有误");
            return  dataResult;
        }
        //验证必填项是否为空
        if (StringUtil.isNullString(userVo.getUserPhone())){
            dataResult.setCode(ResultCode.DEFAULT+"");
            dataResult.setMsg("手机号不能为空！");
            return  dataResult;
        }
        if (StringUtil.isNullString(userVo.getVerifyCode())){
            dataResult.setCode(ResultCode.DEFAULT+"");
            dataResult.setMsg("验证码不能为空！");
            return  dataResult;
        }
        if (StringUtil.isNullString(userVo.getPhoneCode())){
            dataResult.setCode(ResultCode.DEFAULT+"");
            dataResult.setMsg("手机验证码不能为空！");
            return  dataResult;
        }

        //验证密码是否同样
        if(userVo.getUserPassword()==null||"".equals(userVo.getRePassword())||!userVo.getUserPassword().equals(userVo.getRePassword())){
           dataResult.setCode(ResultCode.DEFAULT+"");
            dataResult.setMsg("密码不能为空或两次输入密码不一致");
            return  dataResult;
        }
        //检验密码的长度
        if(userVo.getUserPassword().length()<6||userVo.getUserPassword().length()>30){
            dataResult.setCode(ResultCode.DEFAULT+"");
            dataResult.setMsg("密码长度不能小于6或大于30");
            return  dataResult;
        }

        //验证验证码是否一致
        logger.info("服务器中的图片验证码："+request.getSession().getAttribute("verifyCode"));
        if(userVo.getVerifyCode()==null||"".equals(userVo.getVerifyCode())
                ||!userVo.getVerifyCode().equals(request.getSession().getAttribute("verifyCode"))){
          dataResult.setCode(ResultCode.DEFAULT+"");
            dataResult.setMsg("图片验证码错误或已失效");
            return dataResult;
        }
        //验证手机验证码是否一致
        System.out.println(memberDao.get(userVo.getUserPhone()));
        if(userVo.getPhoneCode()==null||"".equals(userVo.getPhoneCode())||!userVo.getPhoneCode().equals(memberDao.get(userVo.getUserPhone()).getNickname())){
           dataResult.setCode(ResultCode.DEFAULT+"");
            dataResult.setMsg("手机验证码错误");
          return dataResult;
        }
        return dataResult;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
