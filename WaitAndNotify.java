public class WaitAndNotify {
    public static void main(String[] args){
        Object obj = new Object();
        
        // 消费者
        new Thread(){
            @Override
            public void run(){
                synchronized(obj){
                    try{
                        System.out.println(Thread.currentThread().getName()+"进入waitting状态,释放锁对象");
                        obj.wait(); //进入无限等待状态
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"被唤醒");
                }
            }
        }.start();

        // 生产者
        new Thread(){
            @Override
            public void run(){
                try{
                    Thread.sleep(5000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                synchronized(obj){
                    System.out.println(Thread.currentThread().getName()+"获取到锁对象，调用notify方法，释放锁对象");
                    obj.notify();  // 唤醒等待的线程
                }
            }
        }.start();
    } 
}
