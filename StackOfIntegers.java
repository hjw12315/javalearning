public class StackOfIntegers{
	public final static int DEFAULT_CAPACITY = 3;
	private int count = 0;
	private int[] list;
	
	public StackOfIntegers(){
		this(DEFAULT_CAPACITY);
	}
	public StackOfIntegers(int size){
		list = new int[size];
	}
	
	public void push(int value){
		if(count<list.length){
			list[count++] = value;
		}
		else{
			System.out.println("out of bounds");
		}
	}
	
	public int get(){
		if(count>0){
			int value = list[--count];
			System.out.println(value);
			return value;
		}
		else{
			System.out.println("null");
			return -1;
		}
	}
	
	public static void main(String[] args){
		StackOfIntegers s = new StackOfIntegers();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(5);
		s.get();
		s.get();
		s.get();
		s.get();
	}
}