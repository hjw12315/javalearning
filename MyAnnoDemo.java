@MyAnno(ClassName = "完整的包名", MethodName = "sqrt1")
public class MyAnnoDemo {
    public static void main(String[] args){
        Class<MyAnnoDemo> ma = MyAnnoDemo.class;
        MyAnno mya = ma.getAnnotation(MyAnno.class);
        String className = mya.ClassName();   // 获取到的就是 完整的包名
        String methodName = mya.MethodName(); // 获取到的就是 sqrt1
        // 下面就可以使用反射
    }
}
