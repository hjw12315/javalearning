package generator;

import java.util.*;

public class GeneratedArrays {
    // toArray(T[]) 返回一个包含List中的元素的数组
    public static <T> T[] array(T[] a, Generator<T> gen){
        return new CollectionData<T>(gen, a.length).toArray(a);
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> cls, Generator<T> gen, int size){
        T[] a = (T[])java.lang.reflect.Array.newInstance(cls, size);  // 不需要new
        return new CollectionData<T>(gen, size).toArray(a);
    }
}
