package containers;

import java.util.*;
import java.util.BitSet;

public class Bits {
    public static void printBits(BitSet bs){
        System.out.println("bits: " + bs);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<bs.size(); i++){  // bs.size()=64
            sb.append(bs.get(i)?"1":"0");
        }
        System.out.println("bit pattern: " + sb);
    }
    public static void main(String[] args){
        Random random = new Random(47);
        byte bt = (byte)random.nextInt();
        BitSet bst = new BitSet();  // 位存储容器，默认大小为64位
        for(int i=10; i>=0; i--){
            if(((1 << i) & bt) != 0){
                bst.set(i);        // 设置相应的位为 true
            }else{
                bst.clear(i);      // 设置相应的位为 false
            }
        }
        System.out.println("byte value: " + bt);
        printBits(bst);
    }
}
