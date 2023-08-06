package Proxy;

/**
 * @author Chen Manman
 * @since 2023/7/20 10:42
 * 创建代理类并同样实现发送短信的接口
 */
public class StaticSmsProxy implements StaticSmsService {
    private final StaticSmsService smsService;

    public StaticSmsProxy(StaticSmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method send()");
        smsService.send(message);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method send()");
        return null;
    }
}
