package cn.damai.beautiful_article.common.configurations;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

/**
 * Created by Administrator on 2016/11/15 0015.
 */
public class Config  implements Serializable{

    private static final long serialVersionUID = -4157574314529682879L;

    public static String md5_key = "";
    static{
        try {
            Properties props = new Properties();
            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
            md5_key = props.getProperty("md5.key");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
