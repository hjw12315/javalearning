package containers;

import java.util.*;

class Element{
    private String ident;
    public Element(String id){ ident = id; }
    public String toString(){ return ident; }
    public int hashCode(){ return ident.hashCode(); }
    public boolean equals(Object e){
        return e instanceof Element &&
                ident.equals(((Element)e).ident);
    }
    // 垃圾回收器释放占用的内存时调用
    protected void finalize(){
        System.out.println("Finalize "+getClass().getSimpleName()+" "+ident);
    }
}

class Key extends Element{   // Key必须实现hashCode和equals
    Key(String id){super(id);}
}
class Value extends Element{
    Value(String id){super(id);}
}

public class CanoncialMapping {
    public static void main(String[] args){
        int size=20;
        Key[] keys = new Key[size];
        WeakHashMap<Key, Value> map = new WeakHashMap<>();
        for(int i=0; i<size; i++){
            Key key = new Key(Integer.toString(i));
            Value value = new Value(Integer.toString(i));
            if(i%3==0){
                keys[i]=key;  // 此处key指向的那个键不会被回收
            }
            map.put(key, value);
        }
        System.gc();  // 为什么每次获得的结果不一样

        Collection<String> c = new ArrayList<String>();
//        c.add("abc");
        Iterator<String> it = c.iterator();
        c.add("abc");  // 在取得迭代器之后，不能再通过其他的方式修改容器
        try{
            it.next();
        }catch (ConcurrentModificationException e){
            System.out.println(e);
        }
        System.out.println(128&-107);
    }
}
