import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Chen Manman
 * @since 2023/2/22 17:46
 */
public class DeadLock {
    // 线程死锁：多个线程同时被阻塞，它们中的一个或者全部都在等待某个资源被释放。
    // 由于线程被无限期地阻塞，因此程序不可能正常终止。
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    public static void main(String[] args) {
        //线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        threadPool.submit(new Runnable() {
            @Override
            public void run() {

            }
        });


        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        }, "线程1").start();

        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + "get resource1");
                }
            }
        }, "线程2").start();
    }
}
