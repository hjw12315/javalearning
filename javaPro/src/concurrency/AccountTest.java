package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account{
    private double balanced=0.0;
    private Lock lock = new ReentrantLock();

    public void setBalanced(double balanced) {
        lock.lock();
        try{
            Thread.sleep(100);
            this.balanced += balanced;
            System.out.println(Thread.currentThread().getName()+": "+this.balanced);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}

class Customer implements Runnable{
    private Account acc;
    public Customer(Account acc){
        this.acc = acc;
    }

    private static Lock lock = new ReentrantLock();  // 所有对象只能有一把锁

    @Override
    public void run(){
//        lock.lock();
//        try{
//            for(int i=0; i<3; i++){
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                acc.setBalanced(1000);
//            }
//        }finally {
//            lock.unlock();
//        }
        for(int i=0; i<50; i++){
            acc.setBalanced(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account acc = new Account();
        Customer c1 = new Customer(acc);
        Customer c2 = new Customer(acc);

        new Thread(c1,"c1").start();
        new Thread(c2,"c2").start();
    }
}
