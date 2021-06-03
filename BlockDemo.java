import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class BlockDemo {
    public static void main(String[] args){
        var employee = new EmployeeBlock[3];
        employee[0] = new EmployeeBlock("Harry", 40000);
        employee[1] = new EmployeeBlock(30000);
        employee[2] = new EmployeeBlock();

        for(EmployeeBlock e: employee)
            System.out.println(e);

        Arrays.sort(new int[]{1,2,3});
        // List<Integer> list = List.of(1,2,3);  // 为什么不行，创建的是不可变的对象
        // List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> list = new ArrayList<>(List.of(1,7,3,5,4,2,6,3,2,6,5,9,1,0));
        // List<Integer> list = new ArrayList<>();
        list.sort((i,j)->i-j);
        System.out.println(list);
    }   
}

class EmployeeBlock{
    private static int nextId;
    private int id;
    private String name;
    private double salary;

    static  // 只会执行一次，给类初始化
    {
        var generator = new Random();
        nextId = generator.nextInt(10000);
    }
    // new一次执行一次，给所有对象初始化
    {
        id = nextId;
        nextId++;
    }
    // 执行顺序：静态代码块 先于 构造代码块 先于 构造函数

    public EmployeeBlock(){}
    public EmployeeBlock(double salary){
        this("Employee #" + nextId, salary);
    }
    public EmployeeBlock(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName(){return name;}
    public double getSalary(){return salary;}
    public int getId(){return id;}

    @Override
    public String toString(){
        return "EmployeeBolck["+"Id=" + getId() + ", Name=" + getName() + ", Salary=" + getSalary()+"]";
    }

}
