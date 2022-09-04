package Thread;

import java.util.concurrent.*;

public class CompletableFutureTest {
    public static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Main方法开始");

//        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            int i = 1;
//            System.out.println("运行结果：" + i);
//        }, executor);

         /*
         * 方法完成后的感知
         */
//        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            int i = 1;
//            System.out.println("运行结果：" + i);
//            return i;
//        }, executor).whenComplete((result, exception)->{
//            // 虽然能得到异常信息，但没发修改返回数据
//            System.out.println("异步任务成功完成,输出结果为：" + result + "; 异常为：" + exception);
//        }).exceptionally(throwable -> {
//            // 感知异常同时返回默认值
//            return 10;
//        });

        /*
        * 方法执行完成后的处理
        */
//        CompletableFuture<Integer> supplyAsync1 = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            int i = 1;
//            System.out.println("运行结果：" + i);
//            return i;
//        }, executor).handle((result, exception)->{
//            if(result!=null){
//                return result * 2;
//            }
//            if(exception!=null){
//                return 0;
//            }
//            return 0;
//        });
//        Integer integer = supplyAsync.get();
//
//        System.out.println("Main方法结束: " + integer);

        /*
           线程串行化
           1) thenRun: 不能获取到上一步的执行结果
                        .thenRunAsync(() -> {
                    System.out.println("任务2启动");
                }, executor);
           2) thenAcceptAsync: 能接收上一步结果，但是无返回值
                        .thenAcceptAsync((result) -> {
                    System.out.println("任务2启动:" + result);
                }, executor);
           3) thenApplyAsync: 能接收上一步的结果，有返回值
         */

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程：" + Thread.currentThread().getId());
            int i = 1;
            System.out.println("运行结果：" + i);
            return i;
        }, executor).thenApplyAsync((result) -> {
            return "Hello" + result;
        }, executor);
        System.out.println("Main方法结束: "+future1.get());
    }
}
