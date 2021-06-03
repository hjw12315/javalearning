package concurrency.package2;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;

public class ThreadLocalTest {
    private static int a = 500;
    public static void main(String[] args) {

        ThreadLocal threadLocal = new InheritableThreadLocal();  // 用于信息共享
        threadLocal.set("老王");
        ThreadLocal threadLocal2 = new ThreadLocal();
        threadLocal2.set("老王");
        System.out.println(threadLocal.get().equals(threadLocal2.get())); // true
        new Thread(() -> {
            System.out.println(threadLocal.get());   // "老王"
            System.out.println(threadLocal2.get());  // null
            System.out.println(threadLocal.get().equals(threadLocal2.get()));  // false
        }).start();


        new Thread(()->{
            ThreadLocal<Integer> local = new ThreadLocal<Integer>();
            while(true){
                local.set(++a); //子线程对a的操作不会影响主线程中的a, 为什么这里是从22开始？
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程："+local.get());
            }
        }).start();
        a = 22;
        ThreadLocal<Integer> local = new ThreadLocal<Integer>();
        local.set(a);
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程："+local.get());
        }

    }
}



