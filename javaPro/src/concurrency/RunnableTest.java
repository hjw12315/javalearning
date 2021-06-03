package concurrency;

class ThreadRunnable implements Runnable{
    private int ticket = 100;
    private Object obj = new Object();

    @Override
    public void run(){
        while(true){
            synchronized(obj){
                if(ticket>0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" 正在卖第 " +(101-ticket)+" 张票");
                    ticket--;
                }else
                    break;
            }
        }
    }
}

public class RunnableTest{
    public static void main(String[] args) {
        ThreadRunnable mt = new ThreadRunnable();
        new Thread(mt).start();
        new Thread(mt).start();
    }
}
