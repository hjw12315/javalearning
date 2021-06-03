import java.util.Scanner;

public class QuotienWithException{
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.println("please enter two numbers: ");
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		
		try{
			//if(num2==0)
				//throw new ArithmeticException();  // 人为抛出异常
			System.out.println(num1 + "/" + num2 + " equals " + num1/num2);
		}
		catch(ArithmeticException ex){   // 捕获异常
			System.out.println("Exception: an integer cannot be divided by zero");
		}
		finally{  // 有无异常都会执行，即使是前面有return都会执行
			System.out.println("contiues...");
		}
		System.out.println("last");
	}
	
}