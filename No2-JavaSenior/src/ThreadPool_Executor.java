import java.util.concurrent.*;

/**
 * @author Chen Manman
 * @since 2023/2/24 15:39
 */
/*创建线程池的第二种方式：通过 Executor 框架的工具类 Executors 来创建。
可以创建多种类型的 ThreadPoolExecutor：
    1、FixedThreadPool ： 该方法返回一个固定线程数量的线程池。该线程池中的线程数量始终不变。
    当有一个新的任务提交时，线程池中若有空闲线程，则立即执行。若没有，则新的任务会被暂存在一个任务队列中，
    待有线程空闲时，便处理在任务队列中的任务。
    2、SingleThreadExecutor： 该方法返回一个只有一个线程的线程池。若多余一个任务被提交到该线程池，
    任务会被保存在一个任务队列中，待线程空闲，按先入先出的顺序执行队列中的任务。
    3、CachedThreadPool： 该方法返回一个可根据实际情况调整线程数量的线程池。线程池的线程数量不确定，
    但若有空闲线程可以复用，则会优先使用可复用的线程。若所有线程均在工作，又有新的任务提交，则会创建新的线程处理任务。
    所有线程在当前任务执行完毕后，将返回线程池进行复用。
    4、ScheduledThreadPool ：该返回一个用来在给定的延迟后运行任务或者定期执行任务的线程池。

但是，我们不推荐使用Executors来创建线程池，因为：（都可能导致OOM）
    1、FixedThreadPool 和 SingleThreadExecutor ： 使用的是无界的 LinkedBlockingQueue，
    任务队列最大长度为 Integer.MAX_VALUE,可能堆积大量的请求，从而导致 OOM。
    2、CachedThreadPool ：使用的是同步队列 SynchronousQueue, 允许创建的线程数量为 Integer.MAX_VALUE ，
    可能会创建大量线程，从而导致 OOM。
    3、ScheduledThreadPool 和 SingleThreadScheduledExecutor : 使用的无界的延迟阻塞队列DelayedWorkQueue，
    任务队列最大长度为 Integer.MAX_VALUE,可能堆积大量的请求，从而导致 OOM。
 */
public class ThreadPool_Executor {
    // 无界队列 LinkedBlockingQueue
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

    // 无界队列 LinkedBlockingQueue
    ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    //同步队列 SynchronousQueue
    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    //无界的延迟阻塞队列DelayedWorkQueue
    ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
}
