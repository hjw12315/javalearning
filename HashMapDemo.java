import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class HashMapDemo {
    public static void main(String[] args){
        System.out.println("请输入一个字符串: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

        //HashMap<Character, Integer> hm = new HashMap<>();
        TreeMap<Character, Integer> hm = new TreeMap<>();

        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            Integer v = hm.get(c);
            if(v==null)
                hm.put(c, 1);
            else{
                v++;
                hm.put(c, v);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character c : hm.keySet()){
            sb.append(c).append("(").append(hm.get(c)).append(")");
        }
        System.out.println(sb.toString());
    }
}
