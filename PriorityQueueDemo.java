import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.List;

public class PriorityQueueDemo {
    public static void main(String[] args){
        var p = new PriorityQueue<LocalDate>();
        p.add(LocalDate.of(1906, 12, 9));
        p.add(LocalDate.of(1815, 12, 10));
        p.add(LocalDate.of(1903, 12, 2));

        for(Iterator<LocalDate> iter=p.iterator(); iter.hasNext(); ){
            System.out.println(iter.next());
        }
        System.out.println("------");
        while(!p.isEmpty())
            System.out.println(p.remove());

        var array = new ArrayList<String>();
        array.add("a");
        array.add("b");

        String[] values = array.toArray(new String[array.size()]);
        for(int i=0; i<array.size(); i++)
            System.out.println(values[i]);

    }
}
