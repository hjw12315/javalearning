import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.Console;

public class AlgorithmTest{
	
	public static void grammer(){
		System.out.println((1+2.236)/2);
		System.out.println(1+2+3+4.0);
		System.out.println(4.1>=4);
		System.out.println(1+2+"3");
		
		char b = 'b', c ='c';
		System.out.println(b+c);
		System.out.println((char)('a' + 4));
	}
	
	public static void matrix_transposition(int M, int N){
	    //M x N矩阵转
		int max_index = M>N ? M:N;
		int[][] arr = new int[max_index][max_index];
		int s = 0;
		for(int i=0; i<M; i++){
			for(int j=0; j<N; j++){
				arr[i][j] = s;
				s++;
			}	
		}
		
		for(int i=0; i<arr.length; i++){
			for(int j=i; j<arr[i].length; j++){
				if(i!=j){
				arr[i][j] = arr[i][j] + arr[j][i];
				arr[j][i] = arr[i][j] - arr[j][i];
				arr[i][j] = arr[i][j] - arr[j][i];
				}
			}
		}	
		
		for(int i=0; i<N; i++){
			int flag = 0;
			for(int j=0; j<M; j++){
				flag++;
				System.out.print(arr[i][j] + " ");
				if(flag==M)
					System.out.println();
			}
		}
	}
	
	public static int lg(int N){
		// 返回以2为底的sqrt的最大整数
		int i=1;
		int pow=2;
		int flag;
		if(N<=1)
			flag = 0;
		else{
			while(true){
				if(N>=pow)
					break;
				i++;
				pow = pow*2;
			}
			flag = i;
		}
		return flag;
	}
	
	public static int[] histogram(int[] arr, int M){
		int[] array = new int[M];
		
		for(int i=0; i<M; i++){
			int count=0;
			for(int j=0; j<arr.length; j++){
				if(i==arr[j])
					count++;
			}
			array[i] = count;
		}
		return array;
	}
	
	public static void print(){
		Scanner scan = new Scanner(System.in);
		String[] arr = new String[5];
		int row=0;
		String line;
		while(!"end".equals(line = scan.nextLine())){
			//String data = scan.nextLine();  // 整行读取，遇到enter结束
			arr[row] = line;
			row++;
		}
		for(int i=0; i<row; i++){   // 用arr.length空指针异常，arr的长度为5，但是输入不足5个
			//DecimalFormat df = new DecimalFormat("0.000");
			//arr[i][3] = df.format((float)Integer.parseInt(arr[i][1]) / Integer.parseInt(arr[i][2]));
			String[] new_arr = arr[i].split(" ");
			DecimalFormat df = new DecimalFormat("0.000");
			int a = Integer.parseInt(new_arr[1]);
			int b = Integer.parseInt(new_arr[2]);
			String c = df.format((float)a/b);
			//System.out.printf("%s\t%d\t%d\t%.3f\n", new_arr[0],a,b,((float)a/b));
			System.out.printf("%s   %s   %s   %s\n", new_arr[0],new_arr[1],new_arr[2],c);
		}
		
	}
 
	public static void password(){
		Console cons = System.console();
		String username = cons.readLine("User name: ");
		char[] passwd = cons.readPassword("Password: ");
		System.out.println(username);
		for(int i=0; i<passwd.length; i++)
			System.out.print(passwd[i]);
	}
	
	public static void main(String[] args){
		/*
		int a = Integer.parseInt(args[0]);  // String to int     s=i.toSting()  int to String
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		if(a==b && a==c && b==c)      
			System.out.println("equal");
		else
			System.out.println("not equal");
		*/
		/*
		DecimalFormat df = new DecimalFormat("0.000");  //保留三位小数
		String s = df.format((float)1/3);
		System.out.println(s);
		*/ 
		//int ret = lg(1);
		//System.out.println(ret);
		//int[] arr_test = new int[]{1,2,3,0,3,2,1,5};
		//int[] ret2 = histogram(arr_test, arr_test.length);
		//for(int i=0; i<ret2.length; i++)
		//System.out.println(ret2[i]);
		//matrix_transposition(5,4);
		//print();
	}
}