import java.util.HashMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;

public class CollectionPokerDemo{
    public static void main(String[] args){
        HashMap<Integer, String> hm = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        String[] color = {"♥","♣","♠","♦"};
        String[] num = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};

        int index = 0;
        for(String c: num){
            for(String n: color){
                String poker = c+n;
                // 用一个HashMap存储牌的序号和对应的牌
                hm.put(index, poker);
                list.add(index);
                index++;
            }
        }
        hm.put(index, "大王");
        list.add(index);
        index++;
        hm.put(index, "小王");
        list.add(index);
        
        Collections.shuffle(list);

        // TreeSet对牌的序号进行自动排序
        TreeSet<Integer> hu = new TreeSet<>();
        TreeSet<Integer> chen = new TreeSet<>();
        TreeSet<Integer> wang = new TreeSet<>();
        TreeSet<Integer> last = new TreeSet<>();

        for(int i=0; i<list.size(); i++){
            if(list.size()-i<=3){
                last.add(list.get(i));
            }else if(i%3==0){
                hu.add(list.get(i));
            }else if(i%3==1){
                chen.add(list.get(i));
            }else if(i%3==2){
                wang.add(list.get(i));
            }
        }
        showPoker(hu, hm);
        showPoker(chen, hm);
        showPoker(wang, hm);
        showPoker(last, hm);
    }

    public static void showPoker(TreeSet<Integer> ts, HashMap<Integer, String> hm){
        for(Integer i: ts){
            System.out.print(hm.get(i) + " ");
        }
        System.out.println();
    }
}