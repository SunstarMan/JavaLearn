package Proxy;

/**
 * @author Chen Manman
 * @since 2023/7/20 10:40
 * 静态代理实现步骤:
 * 1.定义一个接口及其实现类；
 * 2.创建一个代理类同样实现这个接口
 * 3.将目标对象注入进代理类，然后在代理类的对应方法调用目标类中的对应方法。这样的话，我们就可以通过代理类屏蔽对目标对象的访问，并且可以在目标方法执行前后做一些自己想做的事情。
 */
public interface StaticSmsService {
    String send(String message);
}
