package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Chen Manman
 * @since 2023/7/20 11:02
 * 定义一个 JDK 动态代理类
 */
public class DynamicJDKDebugInvocationHandler implements InvocationHandler {
    private final Object target;

    public DynamicJDKDebugInvocationHandler(Object target) {
        this.target = target;
    }

    //当我们的动态代理对象调用原生方法的时候，最终实际上调用到的是 invoke() 方法，
    // 然后 invoke() 方法代替我们去调用了被代理对象的原生方法
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return result;
    }
}
