package concurrency;


class Interrupt implements Runnable{
    @Override
    public void run(){
        try{
            while(!Thread.interrupted())
                Thread.sleep(100);
        }catch (InterruptedException e) {
            System.out.println("exit");
//                break;
        }
    }
}

public class InterruptedTest {
    public static void main(String[] args) {
        Thread t = new Thread(new Interrupt());
        t.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }
}
