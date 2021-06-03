package concurrency;

class TicketThread extends Thread {
    private static int ticket = 100;
    private static Object obj = new Object();  // 保证锁唯一

    @Override
    public void run(){
        while(true){
            synchronized(TicketThread.class){
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

public class TicketThreadTest{
    public static void main(String[] args) {
        TicketThread tt1 = new TicketThread();
        TicketThread tt2 = new TicketThread();
        tt1.start();
        tt2.start();
    }
}
