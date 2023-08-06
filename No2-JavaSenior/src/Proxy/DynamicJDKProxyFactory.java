package Proxy;

import java.lang.reflect.Proxy;

/**
 * @author Chen Manman
 * @since 2023/7/20 11:06
 * 获取代理对象的工厂类
 */
public class DynamicJDKProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new DynamicJDKDebugInvocationHandler(target) // 代理对象对应的自定义 InvocationHandler
        );
    }
}
