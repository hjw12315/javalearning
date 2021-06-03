package concurrency.WaitAndNotify;

import java.util.Random;
import java.util.concurrent.*;

class Toast{
    public enum Status{ DRY, BUTTERED, JAMMED}
    private Status status = Status.DRY;
    private final int id;
    public Toast(int count){id = count;}
    public int getId(){return id;}
    public void butter(){ status = Status.BUTTERED; }
    public void jam(){ status = Status.JAMMED; }
    public Status getStatus(){ return status; }
    public String toString(){ return id +": "+ status; }

}

// 使用阻塞队列进行线程间的通信
class ToastQueue extends LinkedBlockingQueue<Toast>{}

class Toaster implements Runnable{
    private int count=0;
    private ToastQueue toastQueue;
    private Random random = new Random(47);
    public Toaster(ToastQueue dryQueue){
        this.toastQueue = dryQueue;
    }
    @Override
    public void run(){
        try{
            // 测试当前线程是否被中断，并清除中断状态
            while(!Thread.interrupted()){
//                System.out.println("state: "+Thread.currentThread().isInterrupted());
                TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
                Toast t = new Toast(count++);
                System.out.println(t);
                toastQueue.put(t);
            }
        }catch (InterruptedException e){
            System.out.println("Toaster interrupt");
        }

        System.out.println("toaster exit");
    }
}

class Butter implements Runnable{
    private ToastQueue dryQueue, butterQueue;
    public Butter(ToastQueue dryQueue, ToastQueue butterQueue){
        this.dryQueue = dryQueue;
        this.butterQueue = butterQueue;
    }
    @Override
    public void run(){
        try{
            while(!Thread.interrupted()){
                Toast t = dryQueue.take();
                t.butter();
                System.out.println(t);
                butterQueue.put(t);
            }
        }catch (InterruptedException e){
            System.out.println("Butter interrupt");
        }
        System.out.println("butter exit");
    }
}

class Jam implements Runnable{
    private ToastQueue butterQueue, jamQueue;
    public Jam(ToastQueue butterQueue, ToastQueue jamQueue){
        this.butterQueue = butterQueue;
        this.jamQueue = jamQueue;
    }
    @Override
    public void run(){
        try{
            while (!Thread.interrupted()){
                Toast t = butterQueue.take();
                t.jam();
                System.out.println(t);
                jamQueue.put(t);
            }
        }catch (InterruptedException e){
            System.out.println("jam interrupt");
        }
        System.out.println("jam exit");
    }

}

class Eater implements Runnable{
    private ToastQueue eatQueue;
    private int count=0;
    public Eater(ToastQueue eatQueue){ this.eatQueue = eatQueue; }
    @Override
    public void run(){
        try{
            while(!Thread.interrupted()){
                Toast t = eatQueue.take();
                if(t.getId()!=count++ || t.getStatus()!=Toast.Status.JAMMED){
                    System.out.println("error: "+t);
                    System.exit(1);
                }else{
                    System.out.println("eating " + t);
                }
            }
        }catch (InterruptedException e){
            System.out.println("eater interrupt");
        }
        System.out.println("eater exit");

//        while(!Thread.interrupted()){
//            try{
//                Toast t = eatQueue.take();
//                if(t.getId()!=count++ || t.getStatus()!=Toast.Status.JAMMED){
//                    System.out.println("error: "+t);
//                    System.exit(1);
//                }else{
//                    System.out.println("eating " + t);
//                }
//            }catch (InterruptedException e){
//                System.out.println("eater interrupt");
//                Thread.currentThread().interrupt();
//            }
//        }
//        System.out.println("eater exit");
    }
}

public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException{
        ToastQueue dryQueue = new ToastQueue(),
                butterQueue = new ToastQueue(),
                eatQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butter(dryQueue, butterQueue));
        exec.execute(new Jam(butterQueue, eatQueue));
        exec.execute(new Eater(eatQueue));
        TimeUnit.SECONDS.sleep(1);
        exec.shutdownNow();

    }
}
