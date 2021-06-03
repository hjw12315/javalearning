public class PersonTest{
	public static void main(String[] args){
		// 不带参数初始化
		Person p = new Person();
		p.setAge(18);
		System.out.println(p.getAge());
		
		// 带参数初始化
		Person p2 = new Person(20);
		System.out.println(p2.getAge());
	}
}