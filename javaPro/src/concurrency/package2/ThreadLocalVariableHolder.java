package concurrency.package2;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Accessor implements Runnable{
    private int id;
    public Accessor(int id){
        this.id = id;
    }
    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    public String toString(){
        return "#" + id +": "+ ThreadLocalVariableHolder.get();
    }
}

public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> values = new ThreadLocal<Integer>(){
        private Random rand = new Random(47);
        protected synchronized Integer initialValue(){
            return rand.nextInt();
        }
    };

    public static void increment() {
        values.set(values.get() + 1);
    }

    public static int get() {
        return values.get();
    }

    public static void main(String[] args) throws InterruptedException {
//        new ThreadPoolExecutor(10, 10, ...);  # 手动创建线程，可以根据自己的需求修改线程池的参数
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0; i<5; i++)
            exec.execute(new Accessor(i));
        TimeUnit.MILLISECONDS.sleep(3);
        exec.shutdownNow();
    }
}
