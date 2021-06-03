package concurrency;

class SingletonLazy {
    private static SingletonLazy instance = null;  // 懒汉式
    private SingletonLazy(){}
    public static SingletonLazy getInstance(){
//        //方式一: 效率差
//        synchronized (SingletonLazy.class) {
//            if(instance==null)
//                instance = new SingletonLazy();
//            return instance;
//        }
        // 方式二:
        if(instance==null){
            synchronized(SingletonLazy.class){
                if(instance==null)
                    instance = new SingletonLazy();
            }
        }
        return instance;
    }
}

public class SingletonLazyTest{
    public static void main(String[] args) {
        SingletonLazy sl = SingletonLazy.getInstance();
    }
}
