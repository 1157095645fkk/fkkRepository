package cn.damai.beautiful_article.core.serviceImpl;

import cn.damai.beautiful_article.common.configurations.Config;
import cn.damai.beautiful_article.core.dao.UserMapper;
import cn.damai.beautiful_article.core.domain.User;
import cn.damai.beautiful_article.core.service.UserService;
import cn.damai.beautiful_article.core.vo.UserRegisterLoginVo;
import cn.damai.beautiful_article.core.vo.UserVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Transactional
    public int registerUser(UserRegisterLoginVo userVo) {
        User user = convertVoToPo(userVo);
        int i  = userMapper.save(user);
        return i;
    }
    @Transactional
    public UserVo findByPhone(String userPhone) {
        User user = userMapper.findByPhone(userPhone);
        UserVo userVo=null;
        if (user != null) {
            userVo = convertPoToVo(user);
        }
        return userVo;
    }
   @Transactional
    public int findCountByPhone(String accountId) {
       return userMapper.findCountByPhone(accountId);
    }

    public int findCountByUserName(String userName) {
        return userMapper.findCountByUserName(userName);
    }

    private User convertVoToPo(UserRegisterLoginVo userVo){
        User user = new User();
          user.setUserName(userVo.getUserName());
           String temp = userVo.getUserPassword()+ Config.md5_key;
          String pwd = DigestUtils.md5DigestAsHex(temp.getBytes());
          user.setUserPassword(pwd);
          user.setUserSex(userVo.getUserSex()==2?2:1);
          user.setUserPhone(userVo.getUserPhone());
          user.setUserEmail(userVo.getUserEmail()==null?"":user.getUserName());
          user.setCreateTime(new Date());
          user.setOperateTime(new Date());
        return user;
    }

    /**
     *  po转vo ，并且对密码进行加密
     * @param user
     * @return
     */
    private UserVo convertPoToVo(User user){
       UserVo userVo = new UserVo();
        userVo.setUserId(user.getUserId());
        userVo.setUserName(user.getUserName());
        userVo.setUserPassword(user.getUserPassword());
        userVo.setUserSex(user.getUserSex());
        userVo.setUserPhone(user.getUserPhone()+"");
        userVo.setUserEmail(user.getUserEmail());
        userVo.setCreateTime(user.getCreateTime().toString());
        userVo.setOperateTime(user.getOperateTime().toString());
        userVo.setDataState(user.getDataState()+"");
        return  userVo;
    }
}
