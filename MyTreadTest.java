import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Comparator;

public class MyTreadTest {
    public static void main(String[] args){
        MyThread mt = new MyThread("新线程1--");
        //mt.run();
        mt.start();  //开启多线程，开辟一个新的栈执行run()

        // MyThread2 mt2 = new MyThread2();
        new Thread(new MyThread2(), "新线程2--").start();

        for(int i=0; i<3; i++)
            System.out.println(Thread.currentThread().getName() +" "+ i);

        //匿名内部类实现多线程
        new Thread(){
            @Override
            public void run(){
                System.out.println("匿名内部类1");
            }
        }.start();

        new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("匿名内部类2");
            }
        }).start();

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(0);
        a.add(2);
        a.add(5);
        // a.sort(new Comparator<Integer>(){
        //     @Override
        //     public int compare(Integer i, Integer j){
        //         return i-j;
        //     }
        // });
        a.sort((i, j)->i-j);
    }
}

// 创建线程的第一种方式，继承Thread类
class MyThread extends Thread{
    public MyThread(){}
    public MyThread(String name){
        super(name);
    }

    @Override
    public void run(){
        for(int i=0; i<3; i++)
            System.out.println(getName() + i);
    }
}
// 创建线程的第二种方式，实现Runable接口
// 避免了单继承的局限性；增强了程序的扩展性
class MyThread2 implements Runnable{
    @Override
    public void run(){
        for(int i=0; i<3; i++)
            System.out.println(Thread.currentThread().getName() +" "+ i);
    }
}