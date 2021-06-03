public class Main{
	public static void main(String[] args){
		int[] arr = new int[]{1000, 4000, 999, 70, 5550, 1001, 12000};
		for(int i=0; i<arr.length; i++){
			new Thread(new SleepSort(arr[i])).start();
		}
	}
}
// cao
class SleepSort implements Runnable{
	int num;
	public SleepSort(int num){
		this.num = num;
	}
	@Override
	public void run(){
		try{
			Thread.sleep(num);
			System.out.println(num);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}