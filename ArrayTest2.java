import java.util.Scanner;
import java.util.Arrays;

public class ArrayTest2{
	
	public static void main(String[] args){
		// 静态初始化
		int[][] arr = new int[][]{{1,2,3},{2,4},{3,4}};
		int[][] arr5 = {{1,2,3},{2,3}};
		// 动态初始化
		int[][] arr2 = new int[3][2];
		System.out.println(arr2[0]);       // 输出一个地址     
		System.out.println(arr2[0][0]);
		int[] arr4[] = new int[3][3];
		int[][] arr3 = new int[3][];       // 初始化时外层元素的值为null，取内层元素会报错
		System.out.println(arr3[0]);       // 输出null
		//System.out.println(arr3[0][0]);  // 报错
		// 这种也行
		int a[][] = new int[3][];
		a[0] = new int[2];
		a[1] = new int[3];
		a[2] = new int[4];
		
		
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				System.out.println(arr[i][j]);
			}			
		}
		
		
		//System.out.println("请输入N:");
		//Scanner scan = new Scanner(System.in);
		//int N = scan.nextInt();
		int N = 10;
		int[][] yangHuiTriAngle = new int[N][];		
		for(int i=0; i<yangHuiTriAngle.length; i++){
			yangHuiTriAngle[i] = new int[i+1];       // 初始化不同的长度
			for(int j=0; j<yangHuiTriAngle[i].length; j++){
				if(j==0 | i==j){
					yangHuiTriAngle[i][j] = 1;
				}else{
					yangHuiTriAngle[i][j] = yangHuiTriAngle[i-1][j-1] + yangHuiTriAngle[i-1][j];
				}
			}
		}
		for(int i=0; i<yangHuiTriAngle.length; i++){
			for(int j=0; j<yangHuiTriAngle[i].length; j++){
				if(yangHuiTriAngle[i][j]!=0)
					System.out.print(yangHuiTriAngle[i][j]);
				    System.out.print('\t');
			}	
			System.out.println();
		}
		
		
		// 随机生成两位整数
		int[] randomArr = new int[10];
		for(int i=0; i<randomArr.length; i++){
			randomArr[i] = (int)(Math.random()*(99-10+1) + 10);
			System.out.println(randomArr[i]);
		}
		
		
		// array1和array2指向了同一块堆空间
		System.out.println();
		int[] array1, array2;
		array1 = new int[]{2,3,5,7,11,13,17,19};
		array2 = array1;                    
		//array2 = new int[array1.length];  // 重新new一个空间进行复制
		for(int i=0; i<array2.length;){
			array2[i] = i;
			i += 2;
		}
		System.out.println();
		for(int i=0; i<array1.length; i++){
			System.out.println(array1[i]);
		}

		// 数组反转
		System.out.println();
		String[] str = new String[]{"aa","bb","cc","dd"};
		String temp;
		for(int i=0; i<str.length/2; i++){
			temp = str[i];
			str[i] = str[str.length-i-1];
			str[str.length-i-1] = temp;
		}
		for(int i=0; i<str.length; i++)
			System.out.print(str[i] + '\t');
		
		// 一些方法
		System.out.println();
		int[] arrMethod1 = new int[]{1,2,3,4};
		int[] arrMethod2 = new int[]{1,3,2,4};
		
		boolean isEquals = Arrays.equals(arrMethod1, arrMethod2);
		System.out.println(isEquals);
		System.out.println(Arrays.toString(arrMethod1));
		Arrays.sort(arrMethod2);
		System.out.println(Arrays.toString(arrMethod2));
		int bS_ret = Arrays.binarySearch(arrMethod1, 3);
		System.out.println(bS_ret);
		
		// 二分查找
		// 归并排序、堆排序
	}
}