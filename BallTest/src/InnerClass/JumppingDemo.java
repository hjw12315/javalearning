package InnerClass;

public class JumppingDemo {
    public static void main(String[] args) {
       Jumpping j =  new Jumpping(){
            @Override
            public void jump(){
                System.out.println("jump");
            }
        };

       var jo = new JumppingOperator();
       jo.method(j);

    }
}
