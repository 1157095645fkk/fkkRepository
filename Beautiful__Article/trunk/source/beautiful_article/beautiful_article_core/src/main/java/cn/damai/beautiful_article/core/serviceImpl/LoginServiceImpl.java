package cn.damai.beautiful_article.core.serviceImpl;

import cn.damai.beautiful_article.common.configurations.Config;
import cn.damai.beautiful_article.common.utils.DataResult;
import cn.damai.beautiful_article.core.myEnum.ResultCode;
import cn.damai.beautiful_article.core.service.LoginService;
import cn.damai.beautiful_article.core.service.UserService;
import cn.damai.beautiful_article.core.vo.UserRegisterLoginVo;
import cn.damai.beautiful_article.core.vo.UserVo;
import javafx.scene.chart.PieChart;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

/**
 * Created by fkk on 2017/2/4.
 */
public class LoginServiceImpl implements LoginService{
    @Resource
    UserService userService;

    @Transactional
    public DataResult login(UserRegisterLoginVo userVo,String cacheVerify) {
        DataResult dataResult = new DataResult();
        dataResult.setCode(ResultCode.SUCCESS.getValue()+"");
        String str = userVo.getVerifyCode();
        if(cacheVerify!=null && cacheVerify.equals(str) && userVo.getUserPhone()!=null && userVo.getUserPassword()!=null ){
           UserVo userVo1 = userService.findByPhone(userVo.getUserPhone());
            String temp = userVo.getUserPassword()+ Config.md5_key;
            String pwd = DigestUtils.md5DigestAsHex(temp.getBytes());
           if(userVo.getUserPhone().equals(userVo1.getUserPhone()) && pwd.equals(userVo1.getUserPassword())){
           }else{
                dataResult.setCode(ResultCode.DEFAULT.getValue()+"");
                dataResult.setMsg("用户名或密码错误！");
                return dataResult;
            }
        }else {
         dataResult.setCode(ResultCode.DEFAULT.getValue()+"");
          dataResult.setMsg("验证码或用户名密码不正确，请重新登陆！");
         return dataResult;
        }
        return dataResult;
    }
}
