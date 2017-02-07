package cn.damai.beautiful_article.core.dao;

import cn.damai.beautiful_article.common.dao.Dao;
import cn.damai.beautiful_article.core.domain.User;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/12 0012.
 */

public interface UserMapper extends Dao{

       public User findByPhone(String userPhone);
       public int  findCountByPhone(String userPhone);

       public int findCountByUserName(String userName);
}
