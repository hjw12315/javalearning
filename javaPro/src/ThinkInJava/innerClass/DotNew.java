package ThinkInJava.innerClass;

public class DotNew {
    public class Inner{
        public String toString(){
            return "123";
        }
    }
    public static void main(String[] args){
        DotNew dn = new DotNew();
        DotNew.Inner di = dn.new Inner();
        System.out.println(di);
//         DotNew.Inner di = new DotNew.Inner();  // 不是静态内部类
//         DotNew.Inner di2 = new DotNew().Inner();
    }
}
