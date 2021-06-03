import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args){
        int maxValue = getDate(()->{
            int[] a = {11,23,3,10,2};
            int max = a[0];
            for(int i: a)
                if(i>max)
                    max = i;
            return max;
        });
        System.out.println(maxValue);
    }

    public static int getDate(Supplier<Integer> date){
        return date.get();  // get方法返回一个Integer
    }
}
