package Proxy;

import java.lang.reflect.Proxy;

/**
 * @author Chen Manman
 * @since 2023/7/20 10:47
 * 实际使用
 */
public class StaticMain {
    public static void main(String[] args) {
        StaticSmsService smsService = new StaticSmsServiceImpl();
        StaticSmsProxy smsProxy = new StaticSmsProxy(smsService);
        smsProxy.send("java"); //看输出结果，已经增加了 SmsServiceImpl 的send()方法
    }
}
