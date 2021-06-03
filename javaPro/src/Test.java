import Linkedlist.MyLink;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
////        create two object of every class here
//        Test solution = new Test();
//        Man m1 = solution.createMan("a1", "b1", 11);
//        Man m2 = solution.createMan( "a2", "b2", 12);
//
//        //output them to screen here
//        System.out.println(m1.name + " " + m1.age + " " + m1.address);
//        System.out.println(m2.name + " " + m2.age + " " + m2.address);
//
//        int[] arr1 = new int[]{1,2,3,4,5};
//        String[] string = new String[]{"a","b","c"};
//        for(int i: arr1)
//            System.out.println(i);
//        for(String s: string)
////            System.out.println(s);

    }
    // 定义一个方法，返回Man实例，可以访问非静态的class
    Man createMan(String name, String address, int age) {
        return new Man(name, address, age);
    }
    // 一个文件只能有一个public的class是指最外一层的class
    //add your classes here
    public class Man {
        private String name;
        private String address;
        private int age;

        private Man(String name, String address, int age) {
            this.name = name;
            this.address = address;
            this.age = age;
        }
    }

}
