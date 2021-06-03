import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args){
        String[] strArray = {"林青霞,30", "柳岩,34", "张曼玉,35", "貂蝉,31", "王祖贤,33"};
        ArrayList<String> strings = getPredicate(strArray, s->s.split(",")[0].length()>2, 
                                                    s->Integer.parseInt(s.split(",")[1])>33);
        for(String s: strings)
            System.out.println(s);
    }

    public static ArrayList<String> getPredicate(String[] str, Predicate<String> p1, Predicate<String> p2){
        ArrayList<String> al = new ArrayList<>();
        for(String s: str){
            if(p1.and(p2).test(s))
                al.add(s);
        }    
        return al;   
    }
}
