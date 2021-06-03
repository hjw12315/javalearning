import java.util.Scanner;

public class ScannerDemo{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);  // 从键盘接收数据
		
		int i = 0;
		float f = 0.0f;
		System.out.print("请输入整数:");
		if(scan.hasNextInt()){
			i = scan.nextInt();   // 有next就可以进行输入
			System.out.println("整数数据:" + i);
		}else{
			System.out.println("输入的不是整数！");
		}
		
		
		double sum = 0;
        int m = 0;
 
        while (scan.hasNextDouble()) {  // 输入非数字结束输入
            double x = scan.nextDouble();
            m = m + 1;
            sum = sum + x;
        }
 
        System.out.println(m + "个数的和为" + sum);
        System.out.println(m + "个数的平均值是" + (sum / m));
        scan.close();
		
	}
}
