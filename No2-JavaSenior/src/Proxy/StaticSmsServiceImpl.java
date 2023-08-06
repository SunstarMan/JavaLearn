package Proxy;

/**
 * @author Chen Manman
 * @since 2023/7/20 10:40
 * 实现类：实现发送短信的接口
 */

public class StaticSmsServiceImpl implements StaticSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
