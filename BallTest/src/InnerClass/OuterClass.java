package InnerClass;

public class OuterClass {
    public void method(){
       /*new inter(){   // inter是一个接口
            @Override
           public void show(){
                System.out.println("匿名内部类");
            }
       }.show();*/
        inter i = new inter(){
            @Override
           public void show(){
                System.out.println("匿名内部类");
            }
       };
        i.show();

    }
}
