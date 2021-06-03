import java.util.Arrays;

public class BinarySearch{
	public static void main(String[] agrs){
		/*
		int[] whitelist = In.readInts(args[0]);
		Arrays.sort(whitelist);
		while(!StdIn.isEmpty()){
			int key = StdIn.readInt();
			if(search(key, whitelist)==-1)
				StdOut.println(key);
		}
		*/
	    int[] list = new int[]{1,2,3,4,5,6,7,8,9,10};
		for(int i:list){
			int ret = search(i, list);
			System.out.printf("location: %d\n", ret);
		}
		int ret = search(-1, list);
		System.out.println(ret);
		// 0 error
		System.out.println(1.0/0.0);
		System.out.println(-14%3); // -2
		System.out.println(14%-3); // 2
	}
	
	public static int search(int key, int[] lst){
		int left = 0;
		int right = lst.length - 1;
		while(left<=right){
			int mid = (left+right)/2;
			if(lst[mid]==key) return mid;
			else if(lst[mid]>key) right = mid - 1;
			else left = mid + 1;
		}
		return -1;
	}
}