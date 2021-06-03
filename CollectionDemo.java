import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo {
    public static void main(String[] args){
        var s1 = new StudentCollection("张曼玉", 25);
        var s2 = new StudentCollection("林青霞", 20);
        
        Collection<StudentCollection> c = new ArrayList<>();
        c.add(s1);
        c.add(s2);

        Iterator<StudentCollection> it = c.iterator();
        while(it.hasNext()){
            StudentCollection s = it.next();
            System.out.println(s.getName()+" "+s.getAge());
        }

        System.out.println(method(1,2,3,4,5,6));
            
    }

    public static int method(int... a){
        int sum = 0;
        for(int i=0; i<a.length; i++)
            sum += a[i];
        return sum;
    }
}
