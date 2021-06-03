package concurrency.WaitAndNotify;

class Number implements Runnable{
    private int i = 20;
    @Override
    public void run(){
        while(true){
            synchronized (this) {   // 实现交互打印,线程通信？
//                notify();
                this.notifyAll();   // synchronized是this,这里也要是this,wait也要是this
                if (i > 0) {
                    try {
                        Thread.sleep(10);  // 不会释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ": " + i--);

                    try {
                        this.wait();  // 会释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        new Thread(number,"n1").start();
        new Thread(number,"n2").start();
    }
}
