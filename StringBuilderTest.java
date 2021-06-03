public class StringBuilderTest {
    public static void main(String[] args){
        int[] arr = {1,2,3};
        System.out.println(stringComcat(arr));
    }

    public static String stringComcat(int[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0; i<arr.length; i++){
            if(i==arr.length-1){
                sb.append(arr[i]);
            }else{
                sb.append(arr[i]).append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
