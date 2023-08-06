package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author Chen Manman
 * @since 2022/12/16 16:00
 */
/*
通过 Callable 和 Future 创建线程
1. 创建 Callable 接口的实现类，并实现 call() 方法，该 call() 方法将作为线程执行体，并且有返回值。
2. 创建 Callable 实现类的实例，使用 FutureTask 类来包装 Callable 对象，
该 FutureTask 对象封装了该 Callable 对象的 call() 方法的返回值。
3. 使用 FutureTask 对象作为 Thread 对象的 target 创建并启动新线程。
4. 调用 FutureTask 对象的 get() 方法来获得子线程执行结束后的返回值。
 */

public class ThreadByCallableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /*
        FutureTask 提供了 Future 接口的基本实现，常用来封装 Callable 和 Runnable，
        具有 取消任务、查看任务是否执行完成 以及 获取任务执行结果 的方法。
         */
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("3");
                return "线程3";
            }
        });
        AbstractQueuedSynchronizer
        Thread thread3 = new Thread(futureTask);
        thread3.start();
        String s = futureTask.get();
        System.out.println(s);
    }
}
