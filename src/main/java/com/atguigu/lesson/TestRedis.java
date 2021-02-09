package com.atguigu.lesson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class TestRedis {
    //连接redis客户端
    Jedis jedis;
//    public static void main(String[] args) {
//        //创建一个Jedis
//       jedis = new Jedis("192.168.3.102", 6379);
//        String ping = jedis.ping();
//        System.out.println(ping+"hahah");
//    }
    @Before
    public void init(){
        System.out.println("初始化");
        jedis = new Jedis("172.31.11.100", 6379);
    }

    @After
    public void closeRedis(){
        System.out.println("关闭连接");
        if(null != jedis){
            jedis.close();
        }
    }

    //TODO:string
    @Test
    public void testStr(){
        jedis.set("atguigu","169999");
        System.out.println(jedis.get("atguigu"));
    }

    //TODO:List
    @Test
    public void testList(){
        jedis.lpush("l1","1","2","3");
        System.out.println(jedis.lrange("l1",0,-1));
    }
    //TODO:Set
    @Test
    public void testSet(){
        jedis.sadd("s1","v1","v2","v3");
        System.out.println(jedis.smembers("s1"));
    }

    //TODO:Hash
    @Test
    public void testHash(){
        jedis.hset("h1","name","atguigu");
        jedis.hset("h2","name","atguigu");
        System.out.println(jedis.hmget("h1","name"));
    }

    //TODO:ZSet
    @Test
    public void testZSet(){
        jedis.zadd("z1",60,"zsc");
        jedis.zadd("z1",70,"zsb");
        jedis.zadd("z1",80,"zsa");

        System.out.println(jedis.zrange("z1",0,-1));
    }

}
