package org.example.util;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

/**
 * @author Chen Manman
 * @since 2023/4/4 19:47
 */
public class LettuceUtil {
    private static volatile LettuceUtil lettuceUtil;

    private final RedisClient client;

    private LettuceUtil(String host, int port) {
        RedisURI uri = RedisURI.builder().withHost(host).withPort(port).build();
        client = RedisClient.create(uri);
    }

    public static LettuceUtil getInstance(String host, int port) {
        if (lettuceUtil == null) {
            synchronized (LettuceUtil.class) {
                if (lettuceUtil == null) {
                    lettuceUtil = new LettuceUtil(host, port);
                }
            }
        }
        return lettuceUtil;
    }

    public String set(String key, String value, Long expireTime) {
        StatefulRedisConnection<String, String> connect = this.client.connect();
        RedisCommands<String, String> sync = connect.sync();
        String res = sync.set(key, value);
        if (expireTime != null) {
            sync.expire(key, expireTime);
        }
        connect.close();
        return res;
    }

    public String set(String key, String value) {
        return this.set(key, value, null);
    }
}
