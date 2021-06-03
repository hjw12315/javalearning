import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSecurityDemo {
    public static void main(String[] args){
        ThreadSecutiry ts = new ThreadSecutiry();
        new Thread(ts).start();
        new Thread(ts).start();
        new Thread(ts).start();
    }
}

class ThreadSecutiry implements Runnable{
    private int ticket = 100;

    Lock lock = new ReentrantLock();

    @Override
    public void run(){
        while(true){
            lock.lock();
            if(ticket>0){
                try{
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName()+"正在出售第"+ticket+"张票");
                    ticket--;
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally{
                    lock.unlock();
                }
            }
        }
    }
}
