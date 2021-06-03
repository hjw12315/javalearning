import java.util.Objects;

public class StudentCollection implements Comparable<StudentCollection> {

    private String name;
    private int age;
    private int chinese;
    private int math;
    private int english;

    public StudentCollection(){}
    private StudentCollection(String name){
        this.name = name;
    }
    public StudentCollection(String name, int age){
        this.name = name;
        this.age = age;
    }
    public StudentCollection(String name, int chinese, int math, int english){
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english =english;
    }

    public void setName(String name){this.name = name;}
    public String getName(){return name;}

    public void setAge(int age){this.age = age;}
    public int getAge(){return age;}

    public int getChinese(){return chinese;}
    public int getMath(){return math;}
    public int getEnglish(){return english;}
    public int getTotalScore(){
        return chinese + math + english;
    }

    public void printInfo(){
        System.out.println("配置文件");
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "StudentCollenction{Name=" + name + "}";
    }
 
    @Override
    public int compareTo(StudentCollection s){
        int num = age - s.age;
        int num2 = num==0? name.compareTo(s.name): num;
        return num2;
    }
    
}
