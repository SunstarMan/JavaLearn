import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Chen Manman
 * @since 2023/2/24 20:35
 */
/*AQS:AbstractQueuedSynchronizer,抽象队列同步器。这个类在 java.util.concurrent.locks 包下面。
AQS 就是一个抽象类，主要用来构建锁和同步器。
    1、AQS 为构建锁和同步器提供了一些通用功能的实现，因此，使用 AQS 能简单且高效地构造出应用广泛的大量的同步器，
    比如我们提到的 ReentrantLock，Semaphore，其他的诸如 ReentrantReadWriteLock，SynchronousQueue等等皆是基于 AQS 的。

 */
public class AQSDemo {
    public static void main(String[] args) {
    }
}
