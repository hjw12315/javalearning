public class BinarySearchR{
	public static void main(String[] args){
		int[] lst = new int[]{1,2,3,4,5,6,7,8,9,10};
		int ret = rank(10, lst);
		//System.out.println(ret);
		// 格式化输出
		System.out.printf("Location: %d\n", ret);
	}
	// 重载
	public static int rank(int key, int[] lst){
		return rank(key, lst, 0, lst.length-1);
	}
	public static int rank(int key, int[] lst, int left, int right){
		if(left>right) return -1;
		int mid = (left+right)/2;
		if(key==lst[mid]) return mid;
		else if(key>lst[mid]) return rank(key, lst, mid+1, right);
		else return rank(key, lst, left, mid-1);
	}
}