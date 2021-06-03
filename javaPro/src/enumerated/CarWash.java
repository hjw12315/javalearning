package enumerated;

import java.util.*;

public class CarWash {
    public enum Cycle{
        UNDERNODY{
            void action(){ System.out.println("1"); }
        },
        WHEELWASH{
            void action(){ System.out.println("2"); }
        },
        PREWASH{
            void action(){ System.out.println("3"); }
        },
        BASIC{
            void action(){ System.out.println("4"); }
        },
        HOTWAX{
            void action(){ System.out.println("5"); }
        },
        RINSE{
            void action(){ System.out.println("6"); }
        },
        BLOWDRY{
            void action(){ System.out.println("7"); }
        };
        abstract void action();  // 每个枚举实例可以实现抽象方法
    }
    EnumSet<Cycle> es = EnumSet.of(Cycle.HOTWAX, Cycle.RINSE);
    public void add(Cycle c){ es.add(c); }
    public void wash(){
        for(Cycle c: es)
            c.action();
    }
    public String toString(){
        return es.toString();
    }

    public static void main(String[] args){
        CarWash cw = new CarWash();
        cw.wash();
        cw.add(Cycle.BASIC);
        cw.add(Cycle.BASIC);
        cw.add(Cycle.BLOWDRY);
        System.out.println(cw.toString());
        cw.wash();

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(3,4);
        map.put(3,5);
        for(Integer i: map.keySet()){
            System.out.println(map.get(i));
        }
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        Integer[] a = new Integer[arr.size()];
        int[] b = Arrays.stream(arr.toArray(a)).mapToInt(Integer::valueOf).toArray();
        for(int i: b)
            System.out.println(i);
        String str = "124";
        char[] ch = str.toCharArray();
        for(int i=0; i<ch.length; i++){
            System.out.println((int)ch[i]);


        }
    }
}
