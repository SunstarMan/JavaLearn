package Proxy;

/**
 * @author Chen Manman
 * @since 2023/7/20 11:08
 * 实际使用
 */
public class DynamicJDKMain {
    public static void main(String[] args) {
        DynamicJDKSmsService smsService = (DynamicJDKSmsService) DynamicJDKProxyFactory.getProxy(new DynamicJDKSmsServiceImpl());
        smsService.send("java");

    }
}
