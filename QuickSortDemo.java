import java.util.Arrays;

public class QuickSortDemo {
    public static void main(String[] args){
        int[] src = {1,4,2,5,2,0,3,7,2,3,1};
        QuickSort(src, 0, src.length-1);
        System.out.println("排序后: " + Arrays.toString(src));
        
        String[] array = new String[]{"apple", "pear", "banana", "orange", "pineapple"};
        Arrays.sort(array, (s1, s2)->s1.compareTo(s2));
        System.out.println(Arrays.toString(array));
    }

    private static void QuickSort(int[] arr, int low, int high){
        // Collections.shuffle(Arrays.asList(arr));
        if(low>=high) return;
        int j = Partition(arr, low, high);
        QuickSort(arr, low, j-1);
        QuickSort(arr, j+1, high);
    }

    private static int Partition(int[] arr, int low, int high){
        int i = low, j = high + 1;
        int k = arr[low];  // 如果这里换成一个随机数，该怎么操作？
        while(true){
            while(arr[++i]<k) if(i==high) break; // 找左边大于等于k的数
            while(arr[--j]>k) if(j==low) break;  // 找右边小于等于k的数，j==low的时候循环条件一定为false
            
            if(i>=j) break;  // 先判断是否已经相遇

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // 此时j右边的数都大于k，j左边的数包括j都小于k，交换j和k的位置，进入下一轮划分
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }
}
