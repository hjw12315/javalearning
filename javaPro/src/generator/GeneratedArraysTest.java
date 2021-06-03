package generator;

import java.util.*;

public class GeneratedArraysTest {
    public static void main(String[] args){
        Integer[] a = {1,2,3,4};
        a = GeneratedArrays.array(a, new RandomGenerator.Integer());
        System.out.println(Arrays.toString(a));
        Integer[] b = GeneratedArrays.array(Integer.class, new RandomGenerator.Integer(), 5);
        System.out.println(Arrays.toString(b));

        // toArray()
        ArrayList<Integer> arr = new ArrayList<>(5);
        Collections.addAll(arr, 1,2,3,4,5);
        System.out.println(arr);
        Integer[] ab = {6,5,4,3,2,1};
        Integer[] ir = arr.toArray(ab);  // 如果array的长度超过了List的长度，则超过的部分填充null
        System.out.println(Arrays.toString(ir));

        // Map.Entry接口
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "value1");
        hm.put(2, "value2");
        hm.put(3, "value3");

        StringBuilder sb = new StringBuilder();
        for(Integer i: hm.keySet()){
            sb.append(hm.get(i));
            sb.append(" ");
        }
        System.out.print(sb);
        System.out.println();
        // 通过迭代器来访问Map
        Iterator<Map.Entry<Integer, String>> it = hm.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, String> entry = it.next();
//            it.remove();
            System.out.print(entry.getKey() +"=" + entry.getValue() + " ");
        }
        System.out.println();
        // 通过entrySet来访问Map
        for(Map.Entry<Integer, String> entry: hm.entrySet())
            System.out.print(entry.getKey() +"="+ entry.getValue() + " ");
    }
}
