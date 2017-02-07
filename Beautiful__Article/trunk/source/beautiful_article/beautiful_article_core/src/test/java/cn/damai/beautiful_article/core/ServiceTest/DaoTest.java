package cn.damai.beautiful_article.core.ServiceTest;

import cn.damai.beautiful_article.core.dao.UserMapper;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
public class DaoTest extends BaseTest{

    @Resource
    private UserMapper userMapper;

    @Test
    public void findCountByAccountId(){
        int count= userMapper.findCountByPhone("fkk");
        System.out.println("count:"+count);
    }
}
