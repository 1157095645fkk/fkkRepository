package cn.damai.beautiful_article.action;

/**
 * Created by Administrator on 2016/10/11 0011.
 */

import cn.damai.beautiful_article.common.utils.DataResult;
import cn.damai.beautiful_article.common.utils.VerifyCodeUtil;
import cn.damai.beautiful_article.core.myEnum.ResultCode;
import cn.damai.beautiful_article.core.service.LoginService;
import cn.damai.beautiful_article.core.service.UserService;
import cn.damai.beautiful_article.core.vo.UserRegisterLoginVo;
import cn.damai.beautiful_article.core.vo.UserVo;
import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * 本例中用到的jar文件如下
 *  aopalliance.jar
 * commons-lang3-3.1.jar
 *  commons-logging-1.1.2.jar
 * log4j-1.2.17.jar
 * shiro-all-1.2.2.jar
 *  slf4j-api-1.7.5.jar
 * slf4j-log4j12-1.7.5.jar
 * spring-aop-3.2.4.RELEASE.jar
 *  spring-beans-3.2.4.RELEASE.jar
 *  spring-context-3.2.4.RELEASE.jar
 *  spring-core-3.2.4.RELEASE.jar
 *  spring-expression-3.2.4.RELEASE.jar
 *  spring-jdbc-3.2.4.RELEASE.jar
 *  spring-oxm-3.2.4.RELEASE.jar
 *  spring-tx-3.2.4.RELEASE.jar
 * spring-web-3.2.4.RELEASE.jar
 * spring-webmvc-3.2.4.RELEASE.jar
 *  Sep 30, 2013 11:10:06 PM
 *  玄玉<http://blog.csdn.net/jadyer>
 */
@Controller
@RequestMapping("login")
public class LoginController extends BaseController{
    @Resource
    LoginService loginService;

    @RequestMapping("view")
    public ModelAndView view(Map<String, Object> context) {

        context.put("books", "books");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "xxx");
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @RequestMapping("loginVerify")
    public @ResponseBody String loginVerify(UserRegisterLoginVo userVo) {
        String cacheVerify = (String) request.getSession().getAttribute("verifyCode");
        DataResult dataResult = loginService.login(userVo,cacheVerify);
        if ((ResultCode.SUCCESS.getValue()+"").equals(dataResult.getCode())){
             return "redirect:/main/view.do";
        }
        return  dataResult.getMsg();
    }
/**
 * 获取图片验证码图片和文本（验证码文本会存在HttpSession中）
 */
    @RequestMapping("getVerifyCodeImage")
    public void getVerfyCodeImage(HttpServletRequest request, HttpServletResponse response)throws IOException{
        //设置页面不缓存
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",0);
        String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY,4,null);
        //将验证码放到HttpSession里面
        request.getSession().setAttribute("verifyCode",verifyCode);
        System.out.println("本次生成的验证码为：【"+verifyCode+"】,已存放到HttpSession中");
        //设置输出的内容的类型为jpeg图片
        response.setContentType("image/jpeg");
        BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode,90,33,3,true, Color.white,Color.black,null);
        //写给浏览器
        ImageIO.write(bufferedImage,"JPEG",response.getOutputStream());
    }

    /**
     * 用户登录
     */
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request){
        String resultPageURL = InternalResourceViewResolver.FORWARD_URL_PREFIX+"/";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //获取HttpSession中的验证码
        String verifyCode = (String) request.getSession().getAttribute("verifyCode");
        //获取用户请求表单中输入的验证码
        String submitCode = WebUtils.getCleanParam(request,"verifyCode");
        System.out.println("用户["+username+"]登录时输入的验证码为["+submitCode+"],HttpSession中的验证码为["+verifyCode+"]");
        if(StringUtils.isEmpty(submitCode)||!StringUtils.equals(verifyCode,submitCode.toLowerCase())){
            request.setAttribute("message_login","验证码不正确");
            return  resultPageURL;
        }
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        token.setRememberMe(true);
        System.out.println("为了验证登录用户而封装的token为"+ ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        //获取当前Subject
        Subject currentUser = SecurityUtils.getSubject();
      try {
          //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
          //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
          //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
          currentUser.login(token);
          System.out.println("对用户[" + username + "]进行登录验证..验证通过");
          resultPageURL = "main";
      }catch (UnknownAccountException uae){
          System.out.println("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
          request.setAttribute("message_login", "未知账户");
      }catch(IncorrectCredentialsException ice){
          System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
          request.setAttribute("message_login", "密码不正确");
      }catch(LockedAccountException lae){
          System.out.println("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
          request.setAttribute("message_login", "账户已锁定");
      }catch(ExcessiveAttemptsException eae){
          System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
          request.setAttribute("message_login", "用户名或密码错误次数过多");
      }catch(AuthenticationException ae){
          //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
          System.out.println("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
          ae.printStackTrace();
          request.setAttribute("message_login", "用户名或密码不正确");
      }
        //验证是否登录成功
        if(currentUser.isAuthenticated()){
            System.out.println("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
        }else{
            token.clear();
        }
        return resultPageURL;
    }

    /**
     * 用户登出
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        SecurityUtils.getSubject().logout();
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/";
    }
}
