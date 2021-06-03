import java.util.Arrays;

public class QuickSort3Way{
    public static void main(String[] args){
        Character[] arrChar = {'R','B','W','W','R','W','W','B','X','R','W','B','R'};
        Sort3Way(arrChar, 0, arrChar.length-1);
        System.out.println("排序之后: " + Arrays.toString(arrChar));
    }

    private static <T extends Comparable<T>> void Sort3Way(T[] arr, int low, int high){
        if(low>=high) return;
        T v = arr[low];
        int p = low, i = low + 1, q = high;
        while(i<=q){
            int flag = arr[i].compareTo(v);
            if(flag>0){          // 大于v的放右边
                T temp = arr[i];
                arr[i] = arr[q]; // 交换之后arr[i]和v大小是不确定的，所以i不动，arr[i]继续下一轮比较
                arr[q--] = temp;
            }
            else if(flag<0){     // 小于v的放左边
                T temp = arr[i];
                arr[i++] = arr[p]; // 这时候的arr[i]和v是相等的，所以i++
                arr[p++] = temp;
            }
            else{   // 等于v的放中间
                i++;
            }
        }
        // 大于小于v的再递归
        Sort3Way(arr, low, p-1);
        Sort3Way(arr, q+1, high);
    }
}