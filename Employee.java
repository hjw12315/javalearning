import java.io.*;

/**
@author hul
@version v1.0
my first java program
javadoc -encoding utf-8 -d myjava -author -version Employee.java

文档注释
*/

/*
1.在一个java源文件中可以声明多个class，但是只能是和文件名相同的class声明为public
2.程序入口是main()方法
3.输出:
System.out.println(); 自带换行
System.out.print();   不换行
4.编译(javac)以后会生成一个或多个字节码文件(.class,如果源文件有多个类)
*/

public class Employee{
	
	static int classvariable = 1; // 类变量 static声明
	public String name;           // 实例变量，对子类可见
	private int age;              // 私有变量，只在此类中可见
	String designation;
	double salary;
	
	// 定义一个构造方法
	public Employee(String name){
		this.name = name;
	}
	
	public void empAge(int emp_age){
		int localvariable;    // 局部变量要使用必须先初始化，而全局变量则不用，会默认赋值
		age = emp_age;
	} 
	
	public void empDesignation(String empDesig){
		designation = empDesig;
	}
	
	public void empSalary(double empSalary){
		salary = empSalary;
	}
	
	public void printEmployee(){
		System.out.println("名字:" + name);
		System.out.println("年龄:" + age);
		System.out.println("职位:" + designation);
		System.out.println("薪水:" + salary);
		System.out.println(classvariable);
	}
}