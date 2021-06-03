package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class AtomicityTest implements Runnable{

    private volatile int i = 0;
    public int getI(){ return i; }   // 线程不安全，i可能在处于不稳定的时候被读取 ？
    public synchronized void setI(){
        i++;
        i++;
    }

    @Override
    public void run() {
        while(true)
            setI();
    }

    public static void main(String[] args) {
        AtomicityTest at = new AtomicityTest();
        // Executors.newFixedThreadPool内部是通过ThreadPoolExecutor实现的，返回一个ExecutorService
        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.execute(at);
        while(true){
            int val = at.getI();
            if(val%2!=0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
