package com.home.redis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * Created by li.ma on 2018/8/9.
 */
public class JedisDemo {
    public static void main(String[] args) {
        String redisIp = "192.168.102.211";
        int redisPort = 6379;


        //Jedis jedis = new Jedis(redisIp, redisPort);
       // Pipeline pl = jedis.pipelined();




        Jedis jedis = new Jedis("192.168.102.211");
        //jedis.set
        long start = System.currentTimeMillis();
        Transaction tx = jedis.multi();
        for (int i = 0; i < 100000; i++) {
            tx.set("t" + i, "t" + i);
        }
        List<Object> results = tx.exec();
        long end = System.currentTimeMillis();
        System.out.println("Transaction SET: " + ((end - start)/1000.0) + " seconds");
        jedis.disconnect();
    }
}
