import java.util.function.Consumer;

public class ConsumerDemo {
   public static void main(String[] args){
        getConsumer("java", s->System.out.println(s), s->System.out.println(new StringBuilder(s).reverse().toString()));
   } 

   public static void getConsumer(String name, Consumer<String> con1, Consumer<String> con2){
        // con1.accept(name);
        // con2.accept(name);
        
        //  andThen进行连续操作，先操作con1，再操作con2
        con1.andThen(con2).accept(name); 
   }
}
