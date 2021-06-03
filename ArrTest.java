public class ArrTest{
	public static void main(String[] args){
		int[] arr = new int[]{1,2};
		ArrTest cls = new ArrTest();
		cls.test(arr);
		cls.test2(arr);
		for(int i:arr)
			System.out.println(i);
	}
	// 参数的传递机制:值传递机制（数据值和地址值）
	public void test(int[] arr){
		int temp = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;
	}
	// 这里没有修改arr的指向吗，修改了，但是main里面的打印的arr是第一个arr不是两个方法里面的arr
	// 注意堆和栈的问题，回收问题
	public void test2(int[] arr){
		int[] b = new int[2];
		arr = b;
		for(int i:arr)
			System.out.println(i);
	}
}