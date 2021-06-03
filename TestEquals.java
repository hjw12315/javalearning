import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class TestEquals{
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Xiao", "Ming", 18));
        list.add(new Person("Xiao", "Hong", 25));
        list.add(new Person("Bob", "Smith", 20));
        boolean exist = list.contains(new Person("Bob", "Smith", 20));
        System.out.println(exist ? "测试成功!" : "测试失败!");
    }
}

class Person {
    String firstName;
    String lastName;
    int age;
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    public boolean equals(Object o){
        if(o instanceof Person){
           Person p = (Person) o;
           return Objects.equals(this.firstName, p.firstName) && Objects.equals(this.lastName, p.lastName) && this.age==p.age;
        }
		return false;
    }
}