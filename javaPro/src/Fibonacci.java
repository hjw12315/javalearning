public class Fibonacci {

    public static long F(int N){
        if(N==0) return 0;
        if(N==1) return 1;
        return F(N-1) + F(N-2);
    }
    // long也超出了范围
    public static long F2(int N){
        long[] arr = new long[N+1];
        if(N==0) return 0;
        if(N==1) return 1;
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2; i<=N; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[N];
    }
    public static long F3(int N){
        long a=0;
        long b=1;
        for(int i=0; i<N; i++){
            a = a + b;
            b = a - b;
        }
        return a;
    }
    public static void main(String[] args){
//        for(int i=0; i<100; i++){
//            System.out.println(i+ " " + F(i));
//        }
//        for(int i=0; i<100; i++){
//            System.out.println(i + " "+ F2(i));
//        }
        for(int i=0; i<100; i++){
            System.out.println(i + " " + F3(i));
        }
    }
}
