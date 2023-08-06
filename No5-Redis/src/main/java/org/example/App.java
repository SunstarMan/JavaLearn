package org.example;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;
import org.example.util.LettuceUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RedisURI.Builder builder = RedisURI.builder()
                .withHost("127.0.0.1")
                .withPort(6379);
        RedisURI uri = builder.build();
        RedisClient client = RedisClient.create(uri);
        StatefulRedisConnection<String, String> connect = client.connect();
        RedisCommands<String, String> sync = connect.sync();

//        sync.set("student-1", "jianloveman");
//        String name = sync.get("student-1");
//        System.out.println(name);

//        sync.lpush("student-ages", "10", "20", "30");
//        sync.rpush("student-ages", "80", "60");
//        Long len = sync.llen("student-ages");
//        List<String> list = sync.lrange("student-ages", 0, len);
//        System.out.println(list);
//        sync.lpop("student-ages");
//        sync.rpop("student-ages");
//        List<String> list = sync.lrange("student-ages", 0, -1);
//        System.out.println(list);

//        HashMap<String, String> map = new HashMap<>();
//        map.put("name", "man");
//        map.put("age", "20");
//        map.put("lover", "jian");
//        sync.hset("student-2", map);
//
//        sync.hset("student-3", "name", "jian");
//        sync.hset("student-3", "age", "20");
//        sync.hset("student-3", "lover", "man");
//        Map<String, String> map = sync.hgetall("student-2");
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//        String name = sync.hget("student-2", "name");
//        System.out.println(name);

//        sync.sadd("student-names", "jian", "man");
//        Set<String> names = sync.smembers("student-names");
//        System.out.println(names);
//        sync.expire("student-1", 5);

//        RedisAsyncCommands<String, String> async = connect.async();
//        new Thread(() -> {
//            RedisFuture<String> future = async.set("student-5", "hhh");
//            try {
//                System.out.println(future.get());
//            } catch (InterruptedException | ExecutionException e) {
//                throw new RuntimeException(e);
//            }
//        }).start();
//        System.out.println("dfjskdfjls");

//        LettuceUtil lettuceUtil = LettuceUtil.getInstance("127.0.0.1", 6379);
//        lettuceUtil.set()
    }
}
