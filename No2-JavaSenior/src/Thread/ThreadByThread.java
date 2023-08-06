package Thread;

/**
 * @author Chen Manman
 * @since 2022/12/16 15:45
 */
/*
创建一个线程的第二种方法是创建一个新的类，该类继承 Thread 类，然后创建一个该类的实例。
继承类必须重写 run() 方法，该方法是新线程的入口点。它也必须调用 start() 方法才能执行。
该方法尽管被列为一种多线程实现方式，但是本质上也是实现了 Runnable 接口的一个实例
 */
class ThreadDemo2 extends Thread {
    private final String name;

    public ThreadDemo2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
    }
}

public class ThreadByThread {
    public static void main(String[] args) {
        Thread thread2 = new ThreadDemo2("2");
        thread2.start();
    }
}
