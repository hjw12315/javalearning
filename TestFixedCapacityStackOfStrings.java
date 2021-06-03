import java.util.Scanner;
import java.util.Iterator;
import java.util.Stack;
import java.util.Queue;
import java.util.Deque;
import java.util.LinkedList;
//import java.util.Bag;

public class TestFixedCapacityStackOfStrings{
	
	public static void main(String[] args){
		FixedCapacityStackOfStrings f = new FixedCapacityStackOfStrings(3);
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String in = input.next();
			if(in.equals("end"))
				break;
			f.push(in);
		}
		//while(f.size()!=0)
			//System.out.println(f.pop());
		for(Object s: f)
			System.out.println(s);
		
		//Bag<Double> bag = new Bag<Double>();
		Queue<Integer> queue = new LinkedList<Integer>();  //Queue是一个抽象类，不能实例化
		Deque<Integer> deque = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
	}
}

class FixedCapacityStackOfStrings<Item> implements Iterable<Item>{
	private int N = 0;
	private Item[] s;   //使用数组实现栈
	
	public FixedCapacityStackOfStrings(int size){
		s = (Item[]) new Object[size];  // 使用泛型实例化一个对象 
	}
	
	// 动态调整大小，用链表就方便了
	private void resize(int max){    
		Item[] temp = (Item[]) new Object[max];
		for(int i=0; i<N; i++)
			temp[i] = s[i];
		s = temp;
	}
	
	public void push(Item a){
		if(N==s.length) resize(s.length*2);
		s[N++] = a;
	}
	
	public Item pop(){
		Item item = s[--N];
		s[N] = null;
		if(N>0 && N==s.length/4) resize(s.length/2);
		return item;
	}
	
	public int size(){return N;}
	public boolean isEmpty(){return N==0;}
	
	// 实现foreach
	// iterator是iterable中的抽象方法
	public Iterator<Item> iterator(){return new ReverseArrayIterator();}
	private class ReverseArrayIterator implements Iterator<Item>{
		private int i = N;
		public boolean hasNext(){return i!=0;}
		public Item next(){return s[--i];}
		public void remove(){}
	}
}