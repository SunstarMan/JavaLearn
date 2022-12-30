/**
 * @author Chen Manman
 * @since 2022/12/16 15:41
 */
/*
创建一个线程，最简单的方法是创建一个实现 Runnable 接口的类。
为了实现 Runnable，一个类只需要执行一个方法调用 run()
 */
class ThreadDemo implements Runnable{
    private final String name;

    public ThreadDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
    }
}
public class ThreadByRunnable{
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadDemo("1"));
        thread.start();
    }
}
