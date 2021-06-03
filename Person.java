public class Person{
	private int age;  //会默认赋值为0
	
	public Person(){
		//age = 19;
	}
	
	// 当这里有带参数的构造器时，如果想使用不带参数的构造器，则必须定义一个不带参数的构造器，否则报错
	public Person(int age){
		this.age = age;
	}
	
	public void setAge(int age){
		if(age<0 || age>120)
			throw new RuntimeException("传入的数据非法");
		// 如果不用this,getAge返回的是0,重名冲突
		this.age = age;
	}
	public int getAge(){
		return age;
	}
}