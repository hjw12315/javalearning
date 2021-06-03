package concurrency;

class Cleck{
    private int count = 0;
    public synchronized void produce() {
        if(count<20){
            System.out.println(Thread.currentThread().getName()+":开始生产第 "+ ++count + " 个产品");
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumer() {
        if(count>0){
            System.out.println(Thread.currentThread().getName()+":开始消费第 "+ count-- + " 个产品");
            notify();  // 唤醒被阻塞的生产者
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{
    private Cleck cleck;
    public Producer(Cleck cleck){
        this.cleck = cleck;
    }
    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cleck.produce();
        }
    }

}

class Consumer extends Thread{
    private Cleck cleck;
    public Consumer(Cleck cleck){
        this.cleck = cleck;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cleck.consumer();
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Cleck cleck = new Cleck();
        Producer producer = new Producer(cleck);
        Consumer consumer = new Consumer(cleck);
        producer.setName("生产者");
        consumer.setName("消费者");
        producer.start();
        consumer.start();
//        Consumer consumer2 = new Consumer(cleck);
//        consumer2.start();
    }
}
