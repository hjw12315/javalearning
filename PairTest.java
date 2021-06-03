public class PairTest{
	public static void main(String[] args) {
        Pair<Number> p1 = new Pair<>(12.3, 4.56);
        Pair<Integer> p2 = new Pair<>(123, 456);
        
        setSameSuper(p1, 100);
        setSameSuper(p2, 200);
		getSameExtends(p1, 100);
		getSameExtends(p2, 200);
        System.out.println(p1.getFirst() + ", " + p1.getLast());
        System.out.println(p2.getFirst() + ", " + p2.getLast());
    }
	
	// p的类型要是Integer的父类
    static void setSameSuper(Pair<? super Integer> p, Integer n) {
        p.setFirst(n);
        p.setLast(n);
        p.getFirst();    //不能被接收,因为Integer的父类有多种，要接收只能用Object
        p.getLast();
    }
	
    // p的类型要是Number的子类
	static void getSameExtends(Pair<? extends Number> p, Integer n){
		//p.setFirst(n); //不能设置，因为Number的子类有很多种，类型不确定
		//p.setLast(n);
		Number p1 = p.getFirst();
		Number p2 = p.getLast();
	}
	
}

class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {return first;}
    public T getLast() {return last;}
    public void setFirst(T first) {this.first = first;}
    public void setLast(T last) {this.last = last;}
}
