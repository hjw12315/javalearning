public class LambdaDemo {
    public static void main(String[] args){
        new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("匿名内部类实现一个线程");
            }
        }).start();

        // lambda表达式；包含一个抽象方法的接口，通过lambda表达式实现这个接口的方法，必须要有上下文环境
        Runnable r = ()->System.out.println("lambda表达式实现一个线程");
        new Thread(r).start();



        // 匿名内部类
        useFlyable(new Flyable(){
            @Override
            public void fly(String s){
                System.out.println(s);
                System.out.println("风和日丽");
            }
        });
        System.out.println("+++++++++");

        // lambda表达式
        useFlyable((String s) -> {  
            System.out.println(s);  // 接口方法的具体实现
            System.out.println("飞机自驾游");
        });

        // 方法引用
        useFlyable(System.out::println);

        useAddable((x, y) -> x - y);
    }

    public static void useFlyable(Flyable f){
        f.fly("如何自救");
    }

    public static void useAddable(Addable a){
        int s = a.add(1, 2);
        System.out.println(s);;
    }
}
