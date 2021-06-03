import java.util.Arrays;
import java.util.Random;

public class ShellSorted {
    public static void main(String[] args){
        int[] array = new int[15];
        for(int i=0; i<array.length; i++)
            array[i] = new Random().nextInt(20);
        System.out.println("排序前: " + Arrays.toString(array));
        shell(array);
        System.out.println("排序后: " + Arrays.toString(array));
    }

    public static void shell(int[] arr){
        int len = arr.length;
        int h = 1;
        // 构造一个尾数为1的固定递增序列，递增序列有几个数表示要循环几轮
        // 分别对每一轮使用跳跃间隔为h的插入排序, 最后一轮的h=1表示进行一次完整的插入排序
        while(h<len/3) h = 3*h + 1;  // 1, 4, 13...
        while(h>=1){
            for(int i=h; i<len; i++)
                for(int j=i; j-h>=0 && arr[j]<arr[j-h]; j-=h){
                    int temp = arr[j];
                    arr[j] = arr[j-h];
                    arr[j-h] = temp;
                }
            h = h/3;
        }

        /*
        // 使用不同的递增序列
        for(int k=len/2; k>=1; k=k/2)  
            for(int i=k; i<len; i++)
                for(int j=i; j-k>=0 && arr[j]<arr[j-k]; j-=k){
                    int temp = arr[j];
                    arr[j] = arr[j-k];
                    arr[j-k] = temp;
                }
        */
    }
}
