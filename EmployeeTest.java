import java.io.*;  // 为什么注释了还可以找到？

public class EmployeeTest{ 
	
	public static void main(String[] args){
		// new一个对象
		Employee empone = new Employee("RUNOOB1");
		Employee emptwo = new Employee("RUNOOB2");
		
		empone.empAge(26);
		empone.empDesignation("Senior Programmer");
		empone.empSalary(1000);
		empone.printEmployee();
		
		emptwo.empAge(21);
		emptwo.empDesignation("junior Programmer");
		emptwo.empSalary(500);
		emptwo.printEmployee();
	}
}