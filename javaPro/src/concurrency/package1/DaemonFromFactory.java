package concurrency.package1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable{
    @Override
    public void run(){
        while(true){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()+" "+this);
        }
    }

    public static void main(String[] args) {
        // 通过ThreadFactory来创建新的线程
//        ExecutorService exe = Executors.newCachedThreadPool();
        ExecutorService exe = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for(int i=0; i<10; i++)
            exe.execute(new DaemonFromFactory());
        System.out.println("All Deamon start");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
