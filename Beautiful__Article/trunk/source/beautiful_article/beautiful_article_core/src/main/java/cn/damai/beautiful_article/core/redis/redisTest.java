package cn.damai.beautiful_article.core.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by fkk on 2016/12/2.
 */
public class redisTest {
    public static void main(String args[]){
        Jedis jedis = new Jedis("192.168.153.129",6379);
        jedis.set("jedis","jedis test");
        System.out.println(jedis.get("ok"));
    }
}
