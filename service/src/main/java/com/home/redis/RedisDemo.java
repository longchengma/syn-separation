package com.home.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.List;
import java.util.Map;

/**
 * Created by li.ma on 2019/2/22.
 */
public class RedisDemo {

    public static void main(String[] args) {
        delBigHash("192.168.102.210", 7000, "", "{test}.33");
    }

    public static  void delBigHash(String host, int port, String password, String bigHashKey) {
        Jedis jedis = new Jedis(host, port);
        if(password != null && !"".equals(password)) {
            jedis.auth(password);
        }

        ScanParams scanParams = new ScanParams().count(100);
        String cursor = "0";

        do{



            ScanResult<String> scan = jedis.scan("0");
            System.out.println(scan.getStringCursor());


            ScanResult<Map.Entry<String, String>> scanResult = jedis.hscan(bigHashKey, cursor, scanParams);
            List<Map.Entry<String, String>> entryList = scanResult.getResult();

            if(entryList != null && !entryList.isEmpty()) {
                for(Map.Entry<String, String> entry : entryList)
                {
                    jedis.hdel(bigHashKey, entry.getKey());
                }
            }
            cursor = scanResult.getStringCursor();
        } while(!"0".equals(cursor));

        jedis.del(bigHashKey);   //删除bigkey
    }
}
