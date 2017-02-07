package cn.damai.beautiful_article.core.redisTest;

import cn.damai.beautiful_article.core.dao.UserMapper;
import cn.damai.beautiful_article.core.domain.Member;
import cn.damai.beautiful_article.core.domain.User;
import cn.damai.beautiful_article.core.redis.MemberDao;
import cn.damai.beautiful_article.core.service.MyBaseService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/9/21 0021.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class TestDemo {

    private static Logger logger = Logger.getLogger(TestDemo.class);

    @Resource
    private MemberDao memberDao;

    @Test
    public void test() {
        Jedis jedis = new Jedis("192.168.124.130",6379);
        jedis.set("123","ssssss");
        System.out.println(jedis.get("123"));
    }

    @Test
    public void testRedis(){
        Member member = new Member();
        member.setId("fkk");
        member.setNickname("value");
        memberDao.addAndTime(member,10);
        System.out.println(memberDao.get("fkk"));
        try {
            Thread.sleep(10001);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(memberDao.get("fkk"));
    }
}
