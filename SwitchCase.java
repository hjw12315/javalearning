import java.util.Scanner;

class SwitchCase{
	public static void main(String[] args){
		/* switch case的使用
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入year:");
		int year = scan.nextInt();
		System.out.println("请输出month:");
	    int month = scan.nextInt();
		System.out.println("请输入day:");
		int day = scan.nextInt();
		int count = 0;
		
		switch(month){
		case 12: count += 30;
		case 11: count += 31;
		case 10: count += 30;
		case 9:  count += 31;
		case 8:  count += 31;
		case 7:  count += 30;
		case 6:  count += 31;
		case 5:  count += 30;
		case 4:  count += 31;
		case 3: 
			if (year%4==0 && year%100!=0)
				count += 28;
			count += 29; 
		case 2:  count += 31;
		case 1:  count += day;
		}
		
		System.out.println("已经过了"+count+"天");
		*/
		/* 最大公约数和最小公倍数
		Scanner scan = new Scanner(System.in);
		System.out.println("a:");
		int a = scan.nextInt();
		System.out.println("b:");
		int b = scan.nextInt();
		
		int min=(a>b)?b:a;
		for(int i=min;i>=1;i--){
			if(a%i==0 && b%i==0){
				System.out.println("最大公约数:" + i);
				break;
			}
		}
		
		int max = (a>b)?a:b;
		for(int i=max;i<=a*b;i++){
			if(i%a==0 && i%b==0){
				System.out.println("最小公倍数:" + i);
				break;
			}
		}
		*/
		/* 无限循环
	    int positive = 0;
		int negative = 0;
		Scanner scan = new Scanner(System.in);
		
		//for(;;) 无限循环
	    while(true){
			System.out.println("please enter a number:");
			int i = scan.nextInt();
			if (i!=0){
				if(i>0)
					positive++;
				else
					negative++;
			}else{
				System.out.println("positive "+positive+"  negative "+negative);
				break;
			}
		}
		*/
		
		// 生成素数
		int i=1;
		int num_count = 0;
		
		long start = System.currentTimeMillis();
		while(i<100000){
			int count=1;	
			label:for(int j=3; j<=Math.sqrt(i); j++){
				if(i%j==0){
					count++;
					if(count>=2)
						//label的使用
						break label;
				}
			}
			if(count==1)
				//System.out.println("output:" + i);
				num_count++;
			if(i==1)
			    System.out.println("output:" + 2);
			i += 2;
			
		}
		long end = System.currentTimeMillis();
		System.out.println("共有:" + num_count);
		System.out.println("所花费的时间为:" + (end-start));
		
	}
}