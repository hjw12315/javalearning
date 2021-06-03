import java.util.Scanner;


public class DataKind{	
	public static void main(String[] args){
		
		byte b1 = 10;       // 定义byte
		int b3 = b1 + 3;    // 不同数据类型之间的运算
		System.out.println(b3);
		 
		short s = 12345;     // 定义short
		
		int a;
		a = 100;
		System.out.println("a:" + a);
		
		long l = 1234567L;   // 定义long
		System.out.println(l);
		
		float f = 12.3F;     // 定义float,不加F报错
		System.out.println(f);
		
		double d = 12.3;
		
		int b = (int)12.3;   // 强制类型转换
		System.out.println(b);
		
		int c = 123;
		String s1 = "Hello world!";   // 定义字符串
		String info = s1 + c;         // String可以直接和其他数据类型做连接，与python不同
		System.out.println(info);
		
		int k = 10;
		k += 0.1;
		System.out.println("k:" + k);  // 10
		
		
		int k2 = -10;
		System.out.println(k2 >> 1);
		
		int m=2, n=4, k3=3;
		int max = ((((m>n)?m:n) > k3) ? ((m>n)?m:n) : k3);
		System.out.println("max:" + max);
		
		int n2 = 10;
		n2 = n2 + (n2++) + (++n2);  // 为什么不会先计算括号里面的数
		System.out.println("n2:" + n2);
		
		Scanner scan = new Scanner(System.in);  // 接收
		System.out.println("请输入一个数字:");
		int num = scan.nextInt();   // nextShort() nextDouble() nextFloat() nextBoolean()
		System.out.println(num);
		//scan.close();
		System.out.println("请输入多个字符串:");
		String str = scan.next();   // 获取一个字符串，没有nextChar() 
		System.out.println(str);
        		
		if(scan.hasNextLine()){
			String str2 = scan.nextLine();  // 获取回车之前的所有字符，包括空白
			System.out.println(str2);
		}
		scan.close();
		
		int N = 10;
		double[] arr = new double[N]; // 声明一个数组
		//arr = {1,2,3,4,5};          // 不能直接赋值，要用循环
		int[] numbers = {10,20,30,40,50};
		for(int x:numbers){           // 可迭代对象的循环
			System.out.print(x);
			System.out.print(",");
		}
		
		System.out.println();
		System.out.println(func(a));
		
	}
	
	public static int func(int b){
	int d;
	d = b + 10;  
	return d;	 
	}
}