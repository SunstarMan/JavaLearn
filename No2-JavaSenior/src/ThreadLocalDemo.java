import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @author Chen Manman
 * @since 2023/2/24 11:26
 */
/*
ThreadLocal类主要解决的就是让每个线程绑定自己的值，可以将ThreadLocal类形象的比喻成存放数据的盒子，
盒子中可以存储每个线程的私有数据。
如果你创建了一个ThreadLocal变量，那么访问这个变量的每个线程都会有这个变量的本地副本，这也是ThreadLocal变量名的由来。
他们可以使用 get() 和 set() 方法来获取默认值或将其值更改为当前线程所存的副本的值，
从而避免了线程安全问题。
\
 */
public class ThreadLocalDemo implements Runnable {
    // SimpleDateFormat 不是线程安全的，所以每个线程都要有自己独立的副本
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMDD HHmm"));
    public static void main(String[] args) throws InterruptedException {
        ThreadLocalDemo demo = new ThreadLocalDemo();
        for (int i = 0; i < 10; i++) {
            /*
            Allocates a new Thread object. This constructor has the same effect as Thread (null, target, name).
            Params:分配新的线程对象。此构造函数与Thread（null、target、name）具有相同的效果
            1、target – the object whose run method is invoked when this thread is started.
            If null, this thread's run method is invoked. 启动此线程时调用其运行方法的对象。如果为空，则调用此线程的run方法
            2、name – the name of the new thread 新线程的名称
             */
            Thread thread = new Thread(demo, "t" + i);
            Thread.sleep(new Random().nextInt(1000));
            thread.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread name=" + Thread.currentThread().getName() + " default formatter = " + formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        formatter.set(new SimpleDateFormat());
        System.out.println("Thread Name=" + Thread.currentThread().getName() + " formatter = " + formatter.get().toPattern());
    }
}
