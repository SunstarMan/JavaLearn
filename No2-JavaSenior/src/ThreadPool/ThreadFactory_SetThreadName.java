package ThreadPool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Chen Manman
 * @since 2023/2/24 16:32
 */
/*给线程池里的线程命名通常有下面两种方式：
1、利用 guava 的 ThreadFactoryBuilder
ThreadFactory threadFactory = new ThreadFactoryBuilder()
                        .setNameFormat(threadNamePrefix + "-%d")
                        .setDaemon(true).build();
ExecutorService threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MINUTES, workQueue, threadFactory)

2、自己实现 ThreadFactory。
线程工厂，它设置线程名称，有利于我们定位问题。
 */
public final class ThreadFactory_SetThreadName implements ThreadFactory {
    private final AtomicInteger threadNum = new AtomicInteger();
    private final ThreadFactory delegate;

    private final String name;

    //创建一个带名字的线程池生产工厂
    public ThreadFactory_SetThreadName(ThreadFactory delegate, String name) {
        this.delegate = delegate;
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = delegate.newThread(r);
        t.setName(name + " [#" + threadNum.incrementAndGet() + "]");
        return t;
    }
}
