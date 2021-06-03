import java.util.Iterator;

public class TestStackOfLinkList{
	public static void main(String[] args){
		StackOfLinkList<String> lt = new StackOfLinkList<String>();
		lt.push("1");
		lt.push("a");
		lt.push("123");
		lt.push("befadfas");
		lt.push(".........");
		lt.pop();
		for(String i:lt)
			System.out.println(i);
		System.out.println(lt.getSize());
		System.out.println(lt.isEmpty());
		
		QueueOfStackLinkList<String> q = new QueueOfStackLinkList<String>();
		q.enqueue("123");
		q.enqueue("456");
		q.enqueue("789");
		System.out.println(q.getSize());
		for(String j:q)
			System.out.println(j);
		System.out.println(q.isEmpty());
	}
}

class StackOfLinkList<Item> implements Iterable<Item>{
	private Node first;
	private int N;

	private class Node{
		Node next;
		Item data;
		Node(Item data){
			this.data = data;
		}
	}
	
	public void push(Item data){
		Node node = new Node(data);
		Node temp = first;
		node.next = temp;
		first = node;
		N++;
	}
	
	public Item pop(){
		Item data = null;
		if(first!=null){
			data = first.data;
			first = first.next;
			N--;
		}
		return data;
	}
	
	public Iterator<Item> iterator(){return new StackIterator();}
	private class StackIterator implements Iterator<Item>{
		private Node current = first;
		public boolean hasNext(){
			return current!=null;
		}
		public Item next(){
			Item data = current.data;
			current = current.next;
			N--;
			return data;
		}
		public void remove(){}
	}
	
	public int getSize(){return N;}
	
	public boolean isEmpty(){return N==0;}
	
	public void printNode(){
		while(first!=null){
			System.out.println(first.data);
			first = first.next;
		}
	}
}


class QueueOfStackLinkList<Item> implements Iterable<Item>{
	private Node first;
	private Node last;
	private int N;
	
	private class Node{
		Node next;
		Item data;
	}
	
	public void enqueue(Item data){
		Node oldlast = last;
		last = new Node();  //
		last.data = data;
		last.next = null;
		if(first==null) first=last;
		else oldlast.next = last;
		N++;
	}
	
	public Item dequeue(){
		Item data = first.data;
		first = first.next;
		if(first==null) last=null;
		N--;
		return data;
	}
	
	public Iterator<Item> iterator(){return new QueueIterator();}
	private class QueueIterator implements Iterator<Item>{
		public boolean hasNext(){return N!=0;}
		public Item next(){
			Item data = first.data;
			first = first.next;
			if(first==null) last=null;
			N--;
			return data;
		}
		public void remove(){}
	}
	
	public int getSize(){return N;}
	
	public boolean isEmpty(){return N==0;}
}