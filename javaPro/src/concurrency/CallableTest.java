package concurrency;

/**
 * 1、Callable支持泛型
 * 2、call()可以抛出异常，后面捕获
 * 3、call()有返回值
 * */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class CallableThread implements Callable<Integer>{  // 支持泛型
    @Override
    public Integer call() throws Exception{
        int s = 0;
        for(int i=0; i<=100; i++){
            Thread.sleep(10);
            s += i;
        }
        return s;
    }
}

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableThread ct = new CallableThread();
        FutureTask<Integer> ft = new FutureTask<Integer>(ct);
        new Thread(ft).start();
        new Thread(ft).start();        // FutureTask只会执行一次call()
        if(!ft.isDone()){
            System.out.println("主线程执行其他任务");
        }
        System.out.println(ft.get());  // 获得call()的返回值，会阻塞主线程
        System.out.println("12345");
    }
}
