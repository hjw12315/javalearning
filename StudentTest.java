import java.util.Scanner;

public class StudentTest{

	public static void main(String[] args){
		// static定义的静态成员不能访问非静态成员，要通过实例化的对象来调用
	    // 类里面实例化这个类的对象
		StudentTest test = new StudentTest();
		
		Student[] stu = test.start();	
		test.print(stu);
		System.out.println("**************************");
		test.print_three(stu, 3);
		System.out.println("**************************");	
		test.sort(stu);
		/*sb
		for(int i=0; i<stu.length; i++){
			for(int j=0; j<stu.length-i-1; j++){
				if(stu[j].score < stu[j+1].score){				
					
					stu[j+1].score = stu[j].score + stu[j+1].score;
					stu[j].score = stu[j+1].score - stu[j].score;
					stu[j+1].score = stu[j+1].score - stu[j].score;
					
					stu[j+1].number = stu[j].number + stu[j+1].number;
					stu[j].number = stu[j+1].number - stu[j].number;
					stu[j+1].number = stu[j+1].number - stu[j].number;
					
					stu[j+1].state = stu[j].state + stu[j+1].state;
					stu[j].state = stu[j+1].state - stu[j].state;
					stu[j+1].state = stu[j+1].state - stu[j].state;
					
				}
			}
		}*/
		test.print(stu);
	}
	
	// 创建20个学生对象，返回一个Student数组
	public Student[] start(){
		// ******实例化一个对象数组******
		Student[] arr = new Student[20];
		for(int i=0; i<arr.length; i++){
			arr[i] = new Student();
			arr[i].number = i + 1;
			arr[i].state = (int)(Math.random()*6 + 1);
			arr[i].score = (int)(Math.random()*101);
		}
		return arr;
	}
	
	// 打印学生信息
	public void print(Student[] arr){
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i].info());
	}
	
	// 打印三年级学生信息
	public void print_three(Student[] arr, int state){
		for(int i=0; i<arr.length; i++)
			if(arr[i].state==state)
				System.out.println(arr[i].info());
	}
	
	// 按成绩排序
	public void sort(Student[] arr){
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr.length-i-1; j++){
				if(arr[j].score < arr[j+1].score){
					Student temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
		
}

class Student{
	int number;
	int state;
	int score;
	
	public String info(){
		return "学号：" + number + "，年级：" + state + "，分数：" + score;
	}
}