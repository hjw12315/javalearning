import java.util.Arrays;

public class MaxPQ<T extends Comparable<T>>{
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    private T[] arr; // 用一个数组从下标为1的位置开始存储，当前节点k的父节点为k/2,子节点为2k和2k+1
    private int N = 0;

    @SuppressWarnings("all")
    public MaxPQ(){
        arr = (T[]) new Comparable[DEFAULT_INITIAL_CAPACITY];
    }

    @SuppressWarnings("all")
    public MaxPQ(int MaxN){
        arr = (T[]) new Comparable[MaxN+1];
    }
    public void insert(T t){
        int i = size() + 1;
        if(i>=arr.length)
            arr = Arrays.copyOf(arr, size()*2);
        arr[++N] = t;
        swim(N);        // 每次将添加的元素插入到最后的位置，然后上浮到合适的位置
    }

    public T delMax(){
        T max = arr[1]; // 返回最大的元素，如果要返回最小的元素，只需要改变上浮和下沉的比较
        exch(1, N--);   // 与数组最后的元素交换，数组长度减1，然后将这个元素下沉到合适的位置
        arr[N+1] = null;
        sink(1);
        return max;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public void swim(int k){
        // 上浮的时候与父节点(arr[k/2])比较，大于父节点就上浮
        while(k>1 && arr[k/2].compareTo(arr[k])<0){
            exch(k/2, k);
            k = k/2;
        }
    }

    public void sink(int k){
        while(2*k <= N){  
            int j = 2*k;  
            // 注意j在这一步迭代中要小于剩余元素个数，否则会空指针异常
            // 用较大的子节点(2k或者2k+1)和父节点k比较
            if(j<N && arr[j].compareTo(arr[j+1])<0) j++;
            // 如果父节点大于两个子节点，则不用交换，否则与较大的子节点交换
            if(arr[k].compareTo(arr[j])>0) break; 
            exch(k, j);
            k = 2*k;
        }
    }

    public void exch(int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printArr(){
        for(int i=1; i<=N; i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args){
        MaxPQ<String> arr = new MaxPQ<>(11);
        String[] strings = {"S","G","H","P","N","A","O","E","I","R","T","A"};
        for(String s: strings)
            arr.insert(s);
        arr.printArr();
        System.out.println("+++++++++");
        while(arr.size()!=0){
            arr.delMax();
            arr.printArr(); 
        }  
    }
}

