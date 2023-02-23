import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Chen Manman
 * @since 2023/2/23 16:42
 */
/*
volatile可以保证变量的可见性，但不能保证变量的原子性
 */
public class VolatileDemo {
    public volatile static int a = 0;

    public void increase() {
        a++;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        VolatileDemo volatileDemo = new VolatileDemo();
        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j < 500; j++) {
                    volatileDemo.increase();
                }
            });
        }
        // 等待1.5秒，保证上面程序执行完成
        Thread.sleep(1500);
        System.out.println(a);
        threadPool.shutdown();
    }

    /*
    正常情况下，运行上面的代码理应输出 2500。
    但你真正运行了上面的代码之后，你会发现每次输出结果都小于 2500。
    为什么会出现这种情况呢？不是说好了，volatile 可以保证变量的可见性嘛！
    也就是说，如果 volatile 能保证 a++ 操作的原子性的话,每个线程中对 inc 变量自增完之后，其他线程可以立即看到修改后的值。
    5 个线程分别进行了 500 次操作，那么最终 a 的值应该是 5*500=2500。
    很多人会误认为自增操作 a++ 是原子性的，实际上，inc++ 其实是一个复合操作，包括三步：
        1、读取 a 的值。
        2、对 a 加 1。
        3、将 a 的值写回内存。
    volatile 是无法保证这三个操作是具有原子性的，有可能导致下面这种情况出现：
        1、线程 1 对 a 进行读取操作之后，还未对其进行修改。线程 2 又读取了 a的值并对其进行修改（+1），再将a 的值写回内存。
        2、线程 2 操作完毕后，线程 1 对 a的值进行修改（+1），再将a 的值写回内存。
    这也就导致两个线程分别对 a 进行了一次自增操作后，a 实际上只增加了 1。

    其实，如果想要保证上面的代码运行正确也非常简单，利用 synchronized 、Lock或者AtomicInteger都可以。
        1、使用 synchronized 改进：
        public synchronized void increase() {
            a++;
        }

        2、使用 AtomicInteger 改进：
        public AtomicInteger a = new AtomicInteger();
        public void increase() {
            a.getAndIncrement();
        }

        3、使用 ReentrantLock 改进：
        Lock lock = new ReentrantLock();
        public void increase() {
            lock.lock();
            try {
                inc++;
            } finally {
                lock.unlock();
            }
        }
     */
}
