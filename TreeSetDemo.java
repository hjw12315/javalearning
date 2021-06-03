import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args){
        TreeSet<StudentCollection> t = new TreeSet<>(new Comparator<StudentCollection>(){
            @Override
            public int compare(StudentCollection s1, StudentCollection s2){
                int num = s1.getAge() - s2.getAge();
                int num2 = num==0? s1.getName().compareTo(s2.getName()): num;
                return num2;
            }
        });

        //TreeSet<StudentCollection> t = new TreeSet<>();

        StudentCollection s1 = new StudentCollection("xiaoming", 20);
        StudentCollection s2 = new StudentCollection("qingxia", 23);
        StudentCollection s3 = new StudentCollection("xuzhu", 22);
        StudentCollection s4 = new StudentCollection("xuzhu", 23);
        StudentCollection s5 = new StudentCollection("xuzhu", 23);

        t.add(s1);
        t.add(s2);
        t.add(s3);
        t.add(s4);
        t.add(s5);

        for(StudentCollection s: t)
            System.out.println(s.getName() +" "+ s.getAge());
    }
}
