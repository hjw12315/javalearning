public class AnonymousObj{
	public static void main(String[] args){
		Anonymous an = new Anonymous();
		// 匿名对象，通过定义一个类来进行连续操作
		an.method(new Phone());
		
		int[] arr = new int[10];
		System.out.println(arr);  // 打印出来是地址值
		char[] arr1 = new char[]{'a','b','c'};
		System.out.println(arr1); // 打印出来是abc
	}
}

class Anonymous{
	public void method(Phone phone){
		// 通过这个类来对Phone进行匿名操作
		phone.number = "119";
		phone.sendEmail();
		phone.callPhone();
	}
}

class Phone{
	String number = "110";
	
	public void sendEmail(){
		System.out.println("发邮件");
	}
	public void callPhone(){
		System.out.println("打电话：" + number);
	}
}
