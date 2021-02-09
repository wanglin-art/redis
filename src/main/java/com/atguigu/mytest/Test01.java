package com.atguigu.mytest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class Test01 {
    Jedis jedis;
    public static void main(String[] args) {
        Jedis jedis = new Jedis("161.189.170.231",6379);
        String ping = jedis.ping();
        System.out.println(ping+ "hahahh");
        jedis.close();
    }
    @Before
    public void init(){
        jedis = new Jedis("192.168.3.102",6379);
    }

@Test
public void test(){
    String set = jedis.set("name", "atguigu");
    System.out.println(set);
    System.out.println(jedis.get("name"));
}
@After
public void afterTest(){
        if(jedis!=null){
            jedis.close();
        }
}


}
