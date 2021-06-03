package concurrency;

class ThreadThread extends Thread{
    private int num;
    public ThreadThread(int num){
//        super("子线程");   // 线程命名
        this.num = num;
    }

    @Override
    public void run(){
        for(int i=0; i<num; i=i+2){
            System.out.println(Thread.currentThread().getName() +": "+
                    Thread.currentThread().getPriority() +" "+ i);
            if(i%20==0)
                yield();  // 释放当前CPU的执行权
        }
    }
}

public class ThreadTest{
    public static void main(String[] args) {
        ThreadThread myThread = new ThreadThread(100); // 不能用myThread开多个线程
        myThread.start();
        for(int i=0; i<2; i++)
            new ThreadThread(100).start();
        Thread.currentThread().setName("主线程");  // 线程命名
        System.out.println(Thread.currentThread().getName()+": "+"hello");  // main()是主线程

        for(int i=0; i<50; i++){
            if(i%2==0)
                System.out.println(Thread.currentThread().getName()+": "+
                        Thread.currentThread().getPriority()+" "+i);
            if(i==20) {
                try {
                    myThread.join();  // 主线程进入阻塞状态，myThread运行完之后主线程再执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
