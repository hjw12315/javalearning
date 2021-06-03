package concurrency;

public class MultiLock {
    public synchronized void f1(int flag){
        if(flag-- > 0){
            System.out.println("f1() flag: " + flag);
            f2(flag);
        }
    }
    public synchronized void f2(int flag){
        if(flag-- > 0){
            System.out.println("f2() flag: " + flag);
            f1(flag);
        }
    }

    public static void main(String[] args) {
        MultiLock multiLock = new MultiLock();
        new Thread(){
            @Override
            public void run(){
                multiLock.f1(10);
            }
        }.start();
    }
}
