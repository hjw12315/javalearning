import java.util.Scanner;

// class前面可以是public、final、abstract
public class OOPTest{
	
	public static void main(String[] args){
		Person p1 = new Person("atguigu", true);
		p1.walk();
		String ret = p1.display();
		System.out.println(ret);
	}
}

class Person{
	// 属性
	String name;
	boolean isMarried;
	// 构造器，通过new来调用构造器
	public Person(String n, boolean im){
		name = n; 
		isMarried = im;
	}
	// 方法
	public void walk(){
		System.out.println("人走路");
	}
	public String display(){
		return "名字是: " + name + ", Married: " + isMarried;
	}
	// 代码块
	{
		name = "HanMeiMei";
		int age = 17;
		isMarried = true;
	}
	// 内部类
	class pet{
		String name;
		float weight;
	}
}
