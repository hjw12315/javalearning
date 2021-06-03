public class Recursion {

    public static double ln(int N){
        if(N==1) return Math.log(N);
        return Math.log(N) + ln(N-1);
    }
    public static void main(String[] args){
        System.out.println(ln(4));
    }
}
