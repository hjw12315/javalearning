public class MyStringDemo {
    public static void main(String[] args){

        useMyString((String s, int x, int y)->s.substring(x, y));

        // 类::实例方法；第一个参数作为调用者，后面的参数全部传给方法
        useMyString(String::substring);
    }

    public static void useMyString(MyString m){
        System.out.println(m.mySubString("Hello World", 2, 7));
    }
}
