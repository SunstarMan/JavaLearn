package org.example.util;

import redis.clients.jedis.Jedis;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Chen Manman
 * @since 2023/4/4 14:59
 */
public class RedisConnection {
    //单实例连接（不能对redis连接进行共享）
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost", 6379);
        // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
        // jedis.auth("123456");
        System.out.println("连接成功");
        System.out.println("服务正在运行" + jedis.ping());



    }
}
