package concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        int printNumber = 5;
        Semaphore semaphore = new Semaphore(2);  // 允许并发的数量
        for(int i=0; i<printNumber; i++){
            new Worker(i, semaphore).start();
        }
    }

    static class Worker extends Thread{
        private int i;
        private Semaphore semaphore;
        public Worker(int i, Semaphore semaphore){
            this.i = i;
            this.semaphore = semaphore;
        }
        @Override
        public void run(){
            try {
                semaphore.acquire();
                System.out.println(this.i + "正在执行");
                Thread.sleep(3000);
                System.out.println(this.i + "执行结束");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

