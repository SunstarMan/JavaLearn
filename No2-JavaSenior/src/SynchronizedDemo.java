/**
 * @author Chen Manman
 * @since 2023/2/23 17:29
 */
/*
synchronized 是 Java 中的一个关键字，翻译成中文是同步的意思，主要解决的是多个线程之间访问资源的同步性;
可以保证被它修饰的方法或者代码块在任意时刻只能有一个线程执行。
synchronized 关键字的使用方式主要有下面 3 种：
    1. 修饰实例方法
    2. 修饰静态方法
    3. 修饰代码块
总结：
1. synchronized 关键字加到 static 静态方法和 synchronized(class) 代码块上都是是给 Class 类上锁；
2. synchronized 关键字加到实例方法上是给对象实例上锁；
3. 尽量不要使用 synchronized(String a) 因为 JVM 中，字符串常量池具有缓存功能。

 */
public class SynchronizedDemo {
    public static void main(String[] args) {
    }
}
