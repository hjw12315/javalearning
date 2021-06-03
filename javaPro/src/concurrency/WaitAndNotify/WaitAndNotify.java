package concurrency.WaitAndNotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//// wait and notify
//class Car{
//    private boolean flag = false;
//
//    public synchronized void notifyWaxOn(){
//        flag = false;
//        notify();
//    }
//    public synchronized void notifyBuffing(){
//        flag = true;
//        notify();
//    }
//    public synchronized void waitForWaxing() throws InterruptedException {
//        while(flag==true)
//            wait();
//    }
//    public synchronized void waitForBuffing() throws InterruptedException {
//        while(flag==false)
//            wait();
//    }
//}

class Car{
    private boolean flag = false;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void notifyWaxOn(){
        lock.lock();
        try{
            flag = false;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void notifyBuffing(){
        lock.lock();
        try{
            flag = true;
            condition.signalAll();
        }finally {
            lock.lock();
        }
    }
    public void waitForWaxing() throws InterruptedException {
        lock.lock();
        try{
            while(flag==true)
                condition.await();
        }finally {
            lock.unlock();
        }

    }
    public void waitForBuffing() throws InterruptedException {
        lock.lock();
        try{
            while(flag==false)
                condition.await();
        }finally {
            lock.unlock();
        }
    }
}

class WaxOn implements Runnable{
    private Car car;
    public WaxOn(Car car){ this.car = car; }
    @Override
    public void run(){  // 打蜡
        try{
            while(!Thread.interrupted()){
                System.out.println("Waxing");
                TimeUnit.MILLISECONDS.sleep(100);
                car.notifyBuffing();   // 唤醒抛光线程
                car.waitForWaxing();   // 阻塞打蜡线程
            }
        }catch (InterruptedException e) {
            System.out.println("waxing exit");
        }
    }
}

class Buffing implements Runnable{
    private Car car;
    public Buffing(Car car){this.car = car;}
    @Override
    public void run(){
        try{
            while(!Thread.interrupted()){
                car.waitForBuffing();  // 阻塞抛光线程, 并且防止还没打蜡就抛光(必须要放在前面吗?)
                System.out.println("Buffing");
                TimeUnit.MILLISECONDS.sleep(100);
                car.notifyWaxOn();    // 唤醒打蜡线程
//                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("buffing exit");
        }
    }
}

public class WaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Car car = new Car();
        exec.execute(new WaxOn(car));
        exec.execute(new Buffing(car));   // 有没有可能先执行这个线程？
        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
    }
}
