package cn.damai.beautiful_article.core.ServiceTest;

import cn.damai.beautiful_article.core.serviceutils.SMSUtils;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/11/17 0017.
 */
public class UtilsTest extends BaseTest{
    @Resource
    private SMSUtils smsUtils;

    @Test
    public void smsTest(){
       int value = smsUtils.send("15393169232","1015");
        System.out.println(value);
    }
}
