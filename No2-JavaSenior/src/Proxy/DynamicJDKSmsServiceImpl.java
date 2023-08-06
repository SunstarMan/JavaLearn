package Proxy;

/**
 * @author Chen Manman
 * @since 2023/7/20 11:01
 * 实现发送短信的接口
 */
public class DynamicJDKSmsServiceImpl implements DynamicJDKSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
