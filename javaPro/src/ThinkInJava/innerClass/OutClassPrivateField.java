package ThinkInJava.innerClass;

public class OutClassPrivateField {
    private String name;
    private int age;
    private int num;

    // 内部类生成一个指向外部类的引用，并且内部类构造器的第一个参数就是这个外部类的引用
    public class innerClass{
        private String innername;
        public void func(){
            // 内部类可以调用外部类的私有字段，编译器会为外部类的私有字段创建一个方法
            System.out.println(OutClassPrivateField.this.name);
            System.out.println(OutClassPrivateField.this.age);
            System.out.println(OutClassPrivateField.this.num);
        }
        public innerClass(String innername){
            this.innername = innername;
        }
    }
}
