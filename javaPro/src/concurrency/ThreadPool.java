package concurrency;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.*;

import static java.lang.Thread.yield;

class NumberRun implements Runnable{
    private int s = 0;
    @Override
    public void run() {
        for(int i=0; i<100; i++)
            s += i;
        System.out.println(Thread.currentThread().getName()+": "+s);
    }
}

class NumberCall implements Callable<Integer>{
    private int s = 0;
    @Override
    public Integer call() throws Exception {
        for(int i=0; i<100; i++){
            s += i;
        }
        System.out.println(Thread.currentThread().getName()+": "+s);
        return s;
    }
}

public class ThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Executors.newCachedThreadPool()
        // 核心线程数为0，最大线程数为Integer.MAX_VALUE，空闲线程60s后被回收，允许创建大量线程，不添加任务
        new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L,
                TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

        // Executors.newFixedThreadPool(5);
        // 核心线程数和最大线程数一致，允许添加大量任务
        new ThreadPoolExecutor(5, 5, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        // Executors.newSingleThreadExecutor();
        // 核心线程数和最大线程数都为1，将等待的任务放入队列，队列的最大长度为Integer.MAX_VALUE，允许添加大量任务
        new ThreadPoolExecutor(1, 1, 0L,
                 TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        // Executors.newScheduledThreadPool();
        // 也是通过ThreadPoolExecutor()实现的，可以传入一个ThreadFactory对象


        ExecutorService serviceInterface = Executors.newFixedThreadPool(10);
        // ThreadPoolExecutor接收可以设置线程池属性
        ThreadPoolExecutor service = (ThreadPoolExecutor)serviceInterface;

        service.execute(new NumberRun());  // Runnable线程
        service.submit(new FutureTask<Integer>(new NumberCall()));  // Callable线程
        System.out.println("获取返回值: "+service.submit(new NumberCall()).get());

        service.shutdown();  // 关闭线程池
        // service.shutdownNow();

    }
}
