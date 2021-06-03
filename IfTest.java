public class IfTest{ 
	public static void main(String[] args){
		int x = 3;
		int y = 1;
		if(x>2)
			if (y>2)
				System.out.println("abc");
		// 就近原则
		else
			System.out.println("x is " + x);
		else
			System.out.println(y);
		System.out.println(~x);
	}
}