package concurrency;


public class deadLock {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(() -> {
            synchronized(s1){
                s1.append("a");
                s2.append("1");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized(s2){
                    s1.append("x");
                    s2.append(0);
                }
                System.out.println(s1);
                System.out.println(s2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(s2){
                    s1.append("p");
                    s2.append("3");
                    synchronized(s1){
                        s1.append("q");
                        s2.append("4");
                    }
                    System.out.println(s1);
                    System.out.println(s2);
                }
            }
        }).start();

        new Thread(() -> {   // lambda 函数式接口
            synchronized(s2){
                s1.append("p");
                s2.append("3");
                synchronized(s1){
                    s1.append("q");
                    s2.append("4");
                }
                System.out.println(s1);
                System.out.println(s2);
            }
        }).start();
    }
}
