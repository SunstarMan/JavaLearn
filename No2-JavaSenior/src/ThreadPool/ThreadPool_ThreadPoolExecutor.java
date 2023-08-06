package ThreadPool;

import java.util.concurrent.*;

/**
 * @author Chen Manman
 * @since 2023/2/24 15:40
 */
/*创建线程池的第一种方式：通过ThreadPoolExecutor构造函数来创建（推荐）。

ThreadPoolExecutor 3 个最重要的参数：
    1、corePoolSize : 任务队列未达到队列容量时，最大可以同时运行的线程数量。
    2、maximumPoolSize : 任务队列中存放的任务达到队列容量的时候，当前可以同时运行的线程数量变为最大线程数。
    3、workQueue: 新任务来的时候会先判断当前运行的线程数量是否达到核心线程数，如果达到的话，新任务就会被存放在队列中。

ThreadPoolExecutor其他常见参数 :
    1、keepAliveTime:线程池中的线程数量大于 corePoolSize 的时候，如果这时没有新的任务提交，
    核心线程外的线程不会立即销毁，而是会等待，直到等待的时间超过了 keepAliveTime才会被回收销毁；
    2、unit : keepAliveTime 参数的时间单位。
    3、threadFactory :executor 创建新线程的时候会用到。
    4、handler :饱和策略。关于饱和策略下面单独介绍一下。

如果当前同时运行的线程数量达到最大线程数量并且队列也已经被放满了任务时，ThreadPoolTaskExecutor 定义一些策略:
    1、ThreadPoolExecutor.AbortPolicy： 抛出 RejectedExecutionException来拒绝新任务的处理。
    2、ThreadPoolExecutor.CallerRunsPolicy： 调用执行自己的线程运行任务，也就是直接在调用execute方法的
    线程中运行(run)被拒绝的任务，如果执行程序已关闭，则会丢弃该任务。因此这种策略会降低对于新任务提交速度，
    影响程序的整体性能。如果您的应用程序可以承受此延迟并且你要求任何一个任务请求都要被执行的话，你可以选择这个策略。
    3、ThreadPoolExecutor.DiscardPolicy： 不处理新任务，直接丢弃掉。
    4、ThreadPoolExecutor.DiscardOldestPolicy： 此策略将丢弃最早的未处理的任务请求。

 */
public class ThreadPool_ThreadPoolExecutor {
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
            10,
            2L,
            TimeUnit.MINUTES,
            new LinkedBlockingQueue<>(),
            new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    return new Thread(r);
                }
            },
            new ThreadPoolExecutor.AbortPolicy());

//    public void ThreadPoolExecutor(int corePoolSize,//线程池的核心线程数量
//                                   int maximumPoolSize,//线程池的最大线程数
//                                   long keepAliveTime,//当线程数大于核心线程数时，多余的空闲线程存活的最长时间
//                                   TimeUnit unit,//时间单位
//                                   BlockingQueue<Runnable> workQueue,//任务队列，用来储存等待执行任务的队列
//                                   ThreadFactory threadFactory,//线程工厂，用来创建线程，一般默认即可
//                                   RejectedExecutionHandler handler//拒绝策略，当提交的任务过多而不能及时处理时，我们可以定制策略来处理任务
//    ) {
//        if (corePoolSize < 0 ||
//                maximumPoolSize <= 0 ||
//                maximumPoolSize < corePoolSize ||
//                keepAliveTime < 0)
//            throw new IllegalArgumentException();
//        if (workQueue == null || threadFactory == null || handler == null)
//            throw new NullPointerException();
//    }

}
