package generics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class genericsMethod {
//      这是一个泛型方法，只能传入一种类型
//    public static <T> void test(Collection<T> a, Collection<T> b){
//        int c = 0;
//    }
    public static <T> void test(Collection<? extends T> a, Collection<T> b){
        for(T c: a)
            b.add(c);
        System.out.println(b);
    }

    public static void main(String[] args){
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Object> list2 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        test(list1, list2);
    }
}
