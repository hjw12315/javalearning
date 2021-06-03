import java.util.Scanner;

public class ArrayTest{
	public static void main(String[] args){
		// 静态初始化
		int[] ids;
		ids = new int[]{1,2,3,4,5};
		int[] ids2 = {1,2,3,4,5};  // 推断写法 
		// 动态初始化
		String[] names = new String[5];
		
		
		int[] arr = new int[5];
		// 获取数组的长度arr.length
		for(int i=0; i<arr.length; i++){
			arr[i] = i;
		}
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i]);
		}
		
		// 数组有默认值,不同类型的默认值是0的不同形式,int是0,float是0.0,char是0但是不显示
		char[] arr2 = new char[5];
		for(int i=0; i<arr2.length; i++){
			System.out.println("---" + arr2[i] + "***");
		}
		// boolean数组的默认值为false
		boolean[] arr3 = new boolean[5];
		for(int i=0; i<arr3.length; i++){
			System.out.println(arr3[i]);
		}
		// String的默认值为null
		String[] arr4 = new String[5];
		for(int i=0; i<arr4.length; i++){
			System.out.println(arr4[i]);
		}
		if(arr4[4]==null){
			System.out.println("今天竟然这么少人！");
		}
		
		
		Scanner scan = new Scanner(System.in);
		int[] scores = new int[5];
		int max = 0;
		System.out.println("请输入5个分数:");
		for(int i=0; i<scores.length; i++){
			int a = scan.nextInt();
			scores[i] = a;
			if(scores[i]>max){
				max = scores[i];
			}
		}
		System.out.println("最高分为:" + max);
		System.out.println("冒泡排序:");
		for(int i=0; i<scores.length; i++){
			for(int j=0; j<scores.length-1-i; j++){
				if(scores[j]<scores[j+1]){
					scores[j+1] = scores[j+1] + scores[j];
					scores[j] = scores[j+1] - scores[j];
					scores[j+1] = scores[j+1] - scores[j];
				}
			}
		}
		for(int i=0; i<scores.length; i++){
			System.out.print(scores[i] + "\t");
		}
		System.out.println("\n" + "*******************");
		System.out.println("等级输出:");
		for(int i=0; i<scores.length; i++){
			if(max-10<=scores[i]){
				System.out.println("A: " + scores[i]);
			}else if(max-20<=scores[i]){
				System.out.println("B: " + scores[i]);
			}else if(max-30<=scores[i]){
				System.out.println("C: " + scores[i]);
			}else{
				System.out.println("D: " + scores[i]);
			}
		}
	}
}	