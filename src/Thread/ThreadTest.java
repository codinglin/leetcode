package Thread;

import java.util.concurrent.*;

public class ThreadTest {
    // 当前系统中线程池只有1-2个，每个异步任务，提交给线程池去执行
    public static ExecutorService service = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

        /*
        * 1) 继承Thread
        *       Thread01 thread = new Thread01();
        *       thread.start();
        * 2) 实现Runnable接口
        *       Runnable01 runnable01 = new Runnable01();
        *       new Thread(runnable01).start();
        * 3) 实现Callable接口 + FutureTask (可以拿到返回结果，可以处理异常)
        *       FutureTask<Integer> futureTask = new FutureTask<>(new Callable01());
        *       new Thread(futureTask).start();
        *       // 不同点，线程执行完成可以拿到返回结果
        *       Integer integer = futureTask.get();
        *       System.out.println(integer);
        * 4) 线程池
        *       给线程池直接提交任务
        *       service.execute(new Runnable01());
        *       1、创建
        *           1) Executors
        *           2) new ThreadPoolExecutor
        *
        * 区别：
        *       Thread与Runnable不能得到返回值，Callable可以获取返回值。
        *       以上三种方式都不能控制资源。
        *       线程池可以控制资源，性能稳定。
        */

        /*
         * 七大参数：
         *      corePoolSize: 核心线程数（线程池创建完成后就准备就绪的线程数量，等待来接受异步任务去执行。）
         *      maximumPoolSize: 最大线程数量（控制资源）。
         *      keepAliveTime: 存活时间（当前线程数量大于核心数量，释放空闲的线程 [只要线程空闲大于指定的keepAliveTime]）。
         *      unit: 时间单位
         *      BlockingQueue<Runnable> workQueue: 阻塞队列。如果任务有很多，就会将目前多的任务放在队列里面。
         *                                                 只要线程空闲，就会去队列里面取出新的任务继续执行。
         *      threadFactory: 线程的创建工厂。
         *      handler: 如果队列满了，按照我们指定的拒绝策略拒绝执行任务。
         * 工作顺序：
         *  1、线程池创建，准备好核心线程数，准备接受任务。
         *  2、新任务进来，用核心线程中的空闲线程执行。
         *      1）核心线程满，那么再新进来的任务放入阻塞队列中。空闲的核心线程就会自己去阻塞队列获取任务执行.
         *      2）阻塞队列满了，就直接开新线程执行，最大只能开到max指定的数量
         *      3）max执行好了。max-core数量的空闲线程会在keepAliveTime指定的时间后自动销毁。最终保持在核心线程数的大小。
         *      4）如果线程数开到了max的数量，还有新任务进来，就会使用reject指定的拒绝策略进行处理。
         *  3、所有的线程创建都是由指定的 factory 创建。
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 200, 10, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        // 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
        ExecutorService cachedService = Executors.newCachedThreadPool();

        // 固定大小
        ExecutorService newFixedService = Executors.newFixedThreadPool(10);

        // 定时任务的线程池
        Executors.newScheduledThreadPool(10);

        // 单线程的线程池
        Executors.newSingleThreadExecutor();

        System.out.println("Main方法结束");
    }

    static class Thread01 extends Thread{
        @Override
        public void run() {
            System.out.println("当前线程：" + Thread.currentThread().getId());
            int i = 1;
            System.out.println("运行结果：" + i);
        }
    }

    static class Runnable01 implements Runnable{
        @Override
        public void run() {
            System.out.println("当前线程：" + Thread.currentThread().getId());
            int i = 1;
            System.out.println("运行结果：" + i);
        }
    }

    static class Callable01 implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            System.out.println("当前线程：" + Thread.currentThread().getId());
            int i = 1;
            System.out.println("运行结果：" + i);
            return i;
        }
    }
}
