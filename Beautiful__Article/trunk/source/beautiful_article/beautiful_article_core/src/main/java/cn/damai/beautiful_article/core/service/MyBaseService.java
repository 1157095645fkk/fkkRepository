package cn.damai.beautiful_article.core.service;

import cn.damai.beautiful_article.core.dao.UserMapper;
import cn.damai.beautiful_article.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/9/12 0012.
 */
@Service
public class MyBaseService {
    @Autowired
    private UserMapper userMapper;

    public String testDao(){
        User user = userMapper.findById(1);
        return user.toString();
    }
    public  String testService(){
        return "service没什么问题！";
    }
}
