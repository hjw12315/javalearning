package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BlockedMutex{
    private Lock lock = new ReentrantLock();
    public BlockedMutex(){
        lock.lock();
    }
    public void f(){
        try {
            lock.lockInterruptibly();  // 获取锁,如果线程中断了会抛出异常
            System.out.println("lock acquired in f()");
        } catch (InterruptedException e) {
            System.out.println("interrupted from lock acquisition in f()");
        }
    }
}

class Blocked2 implements Runnable{
    final BlockedMutex blockedMutex = new BlockedMutex();
    @Override
    public void run(){
        System.out.println("waiting for f() in BlockedMutex");
        blockedMutex.f();
        System.out.println("Broken");
    }
}

public class Interrupting2 {
    public static void main(String[] args) {
        Thread t = new Thread(new Blocked2());
        t.start();
        t.interrupt();
    }
}
