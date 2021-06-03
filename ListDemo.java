import java.util.*;

public class ListDemo {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");

        Iterator<String> itr = list.iterator();

        /* 
        while(it.hasNext()){
            String s = it.next();  //并发修改异常
            if(s.equals("java"))
                list.add("error");
        }*/

        for(int i=0; i<list.size(); i++){
            String s = list.get(i);
            if(s.equals("java"))
                list.add("yes");
        }
    }
}
