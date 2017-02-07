package cn.damai.beautiful_article.core.ServiceTest;

import cn.damai.beautiful_article.core.dao.SystemLogMapper;
import cn.damai.beautiful_article.core.dao.UserMapper;
import cn.damai.beautiful_article.core.domain.SystemLog;
import cn.damai.beautiful_article.core.domain.User;
import cn.damai.beautiful_article.core.service.MyBaseService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/21 0021.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class TestDemo{

    private static Logger logger = Logger.getLogger(TestDemo.class);

   @Resource
    private  UserMapper userMapper;

    @Resource
    private SystemLogMapper systemLogMapper;

    @Resource
    private MyBaseService myBaseService;


    @Test
    public void testService() {
        User user = new User();
        user.setUserName("李四");
        user.setUserPassword("893253");
        user.setCreateTime(new Date());
        user.setOperateTime(new Date());
        user.setUserEmail("1111@qq.com");
        user.setUserPhone("123213");
        user.setUserSex(1);
       userMapper.save(user);
    }
    @Test
    public void testService2(){
        SystemLog systemLog = new SystemLog();
        systemLog.setLogType(1);
        systemLog.setLogContent("12343");
        systemLog.setUserId(123);
        systemLogMapper.save(systemLog);
    }
}
