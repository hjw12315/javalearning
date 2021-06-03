package generator;

import java.util.ArrayList;

public class CollectionData<T> extends ArrayList<T> {
    // 传入一个生成器参数，根据不同的生成器生成不同类型的List
    public CollectionData(Generator<T> g, int length){
        for(int i=0; i<length; i++)
            add(g.next());   // 使用生成器生成随机数,然后加入到list中
    }

    public static <T> CollectionData<T> list(Generator<T> gen, int length){
        return new CollectionData<T>(gen, length);
    }
}
