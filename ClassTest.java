import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Constructor;

public class ClassTest{
    public static void main(String[] args) throws Exception{
        Student stu = new Student("xiaoming", 100, 1);
        Class cls = stu.getClass();
        Method fs = cls.getMethod("setName", String.class); //public void Person.setName(java.lang.String)
        Method fn = cls.getDeclaredMethod("setScore", int.class);  //public void Student.setScore(int)
        System.out.println(fs); 
        System.out.println(fn); 
        System.out.println(fs.getName());  // setName
        System.out.println(fs.getReturnType()); // void
        System.out.println(fs.getParameterTypes()); //
        int m = fs.getModifiers();
        System.out.println(Modifier.isPublic(m)); // true

        Method[] f1 = cls.getMethods();
        for(Method i: f1)
            System.out.println(i);
        Method[] f2 = cls.getDeclaredMethods();
        for(Method j: f2)
            System.out.println(j);

        fn.invoke(stu, 98);  // invoke就相当于setScore,只不过第一个参数为实例
        System.out.println(stu.getScore());  // 98

        Method ft = cls.getDeclaredMethod("setTest", int.class);
        ft.invoke(null, 2);  // 访问静态方法
        System.out.println(Student.test);  // 2

        Method fh = Person.class.getMethod("hello");  // 是获取Person的还是子类的？
        fh.invoke(new Student());  // 还是调用子类的方法

        Constructor cons = cls.getConstructor(); // public Student()
        System.out.println(cons);
        Constructor cons3 = cls.getConstructor(String.class, int.class, int.class); //public Student(java.lang.String,int,int)
        System.out.println(cons3);
        Student s = (Student)cons3.newInstance("xiaohong", 100, 3);  // 创建实例
        System.out.println(s.getName());

        Class i = Integer.class.getSuperclass(); // 获取父类
        System.out.println(i);  
        Class o = i.getSuperclass();
        System.out.println(o);
    }
}

class Student extends Person{
    public int score;
    private int grade;
    static int test = 1;

    public Student(){}
    public Student(String name, int score, int grade){
        super(name);
        this.score = score;
        this.grade = grade;
    }

    public void setScore(int score){this.score = score;}
    public int getScore(){return score;}
    static void setTest(int t){test = t;}
    public void hello(){System.out.println("Student:hello()");}
}

class Person{
    private String name;  

    public Person(){}
    public Person(String name){
        this.name = name;
    }

    public void setName(String name){this.name = name;}
    public String getName(){return name;}
    public void hello(){System.out.println("Person:hello()");}
}