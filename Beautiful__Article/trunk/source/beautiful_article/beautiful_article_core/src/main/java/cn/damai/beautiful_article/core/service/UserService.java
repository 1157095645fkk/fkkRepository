package cn.damai.beautiful_article.core.service;

import cn.damai.beautiful_article.core.vo.UserRegisterLoginVo;
import cn.damai.beautiful_article.core.vo.UserVo;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
@Service
public interface UserService {

    public int registerUser(UserRegisterLoginVo userVo);

    public UserVo findByPhone(String userPhone);
    /**
     * 根据账户查询有多少个该相同账户
     */
    public int findCountByPhone(String userPhone);
    /**
     * 查询有多少个想吐的用户名
     */
    public int findCountByUserName(String userName);
}
