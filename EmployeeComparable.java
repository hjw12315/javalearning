public class EmployeeComparable implements Comparable<EmployeeComparable>{
    private String name;
    private double salary;

    public EmployeeComparable(String name, double salary){
            this.name = name;
            this.salary = salary;
    }
    public String getName(){return name;}
    public double getSalary(){return salary;}
    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }
    
    // 继承了Comparable接口，重写compareTo方法
    public int compareTo(EmployeeComparable other){
        return Double.compare(salary, other.salary);
    }
}
