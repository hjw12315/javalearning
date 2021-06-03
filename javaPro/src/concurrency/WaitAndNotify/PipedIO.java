package concurrency.WaitAndNotify;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


// 使用管道进行线程之间的通信
class Sender implements Runnable{
    private PipedWriter out = new PipedWriter();
    public PipedWriter getPipedWriter() {return out;}
    @Override
    public void run(){
        try{
            while(true)
                for(char c='a'; c<'z'; c++){
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(100);
                }
        }catch (IOException e){
            System.out.println("sender write exception");
        }catch (InterruptedException e){
            System.out.println("sender exception>>> " + e);  //
        }
    }
}

class Receiver implements Runnable{
    private PipedReader in;
    public Receiver(Sender sender) throws IOException {
        in = new PipedReader(sender.getPipedWriter());
    }
    @Override
    public void run(){
        try{
            while(true){
                System.out.println("reader:" + (char)in.read());
            }
        }catch (IOException e){
            System.out.println("receiver exception>>> " + e); // 可中断
        }
    }
}

public class PipedIO {
    public static void main(String[] args) throws IOException, InterruptedException {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
    }
}
