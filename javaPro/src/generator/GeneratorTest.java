package generator;

public class GeneratorTest {
    public static int size = 10;
    public static void test(Class<?> surroundingClass){
        for(Class<?> cls: surroundingClass.getClasses()){
            System.out.print(cls.getSimpleName() + ": ");
            try {
                Generator<?> gr = (Generator<?>)cls.newInstance();
                for(int i=0; i<size; i++)
                    System.out.print(gr.next() + " ");
                System.out.println();
            }
            catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args){
        test(CountingGenerator.class);
    }

}
