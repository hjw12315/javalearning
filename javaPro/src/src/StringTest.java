package src;

public class StringTest {
    public static void main(String[] args){
        String s1 = "abc";
        // 返回对象在堆中的引用
        String s2 = new String("abc");
        // intern()的作用：如果字符串常量池存在这个对象，则直接返回池中的对象，
        // 如果不存在则在常量池创建并返回，不需要在堆中创建
        String s3 = new String("abc").intern();
        System.out.println(s1==s2);
        System.out.println(s1==s3);
    }
}
