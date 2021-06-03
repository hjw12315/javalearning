package containers;

import java.util.*;

public class Unsupported {
    static void test(String msg, List<String> list){
        System.out.println(msg + ": ");
        Collection<String> c = list;
        Collection<String> c2 = new ArrayList<>(list.subList(1,3));
        try{c.retainAll(c2);} catch (Exception e){
            System.out.println("retainALL: " + e);
        }
        try{c.clear();} catch (Exception e){
            System.out.println("clear: " + e);
        }
        try{c.addAll(c2);} catch(Exception e){
            System.out.println("addAll: " + e);
        }
        try{c.add("123");} catch (Exception e){
            System.out.println("add: " + e);
        }
        try{c.remove("c");} catch (Exception e){
            System.out.println("remove: " + e);
        }
        try{list.set(0, "p");} catch (Exception e){
            System.out.println("list set: " + e);
        }
    }

    public static void main(String[] args){
        List<String> lst = Arrays.asList("a b c d e f g".split(" "));
        test("asList", lst);
        test("ArrayList", new ArrayList<String>(lst));
        test("unmodifiable", Collections.unmodifiableList(new ArrayList<>(lst)));
    }
}
