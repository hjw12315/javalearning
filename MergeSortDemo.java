import java.util.Arrays;

public class MergeSortDemo {
    private static final int INSERTIONSORT_THRESHOLD = 7;
    public static void main(String[] args){
        int[] src = {1,4,2,5,2,0,3,7,2,3,1};
        int[] dest = src.clone();
        MergeSort(src, dest, 0, src.length);
        System.out.println("排序后：" + Arrays.toString(src));

        int[] src2 = {1,4,2,5,2,0,3,7,2,3,1};
        int[] aux = new int[src2.length];
        MergeSortTB(src2, aux, 0, src2.length-1);
        System.out.println("排序后：" + Arrays.toString(src2));

        int[] src3 = {1,4,2,5,2,0,3,7,2,3,1};
        int[] aux2 = new int[src3.length];
        MergeSortBU(src3, aux2);
        System.out.println("排序后：" + Arrays.toString(src3));
    }

    // 归并+插入
    public static void MergeSort(int[] src, int[] dest, int right, int left){
        int len = left - right;
        // 写一个插入排序
        if(len<INSERTIONSORT_THRESHOLD){
            for(int i=right; i<left; i++){
                for(int j=i; j>right && dest[j]<dest[j-1]; j--){
                    int temp = dest[j-1];
                    dest[j-1] = dest[j];
                    dest[j] = temp;
                }
            }
            return;
        }

        int mid = (right + left) >>> 1;
        MergeSort(src, dest, right, mid);
        MergeSort(src, dest, mid, left); // 递归+插入将左右两边的先各自排好，最后一轮视情况而定

        // 如果右边的第一位大于左边的最后一位则直接返回
        if(dest[mid]>dest[mid-1]){
            System.arraycopy(dest, right, src, right, len);
            return;
        }

        for(int i=0, p=right, q=mid; i<left; i++){
            // 使用双指针要注意“短路或”问题，对left的判断要放前面才会去判断后面的
            // 如果q指针为true(超出界限), 说明右边处理完了, 接下来要处理p;
            // 如果p指针为false(超出界限), 说明左边处理完了, 接下来要处理q;
            if(q>=left || p<mid && dest[p]<=dest[q]){
                // System.out.println(p+" "+q);
                src[i] = dest[p++];
            }
            else{
                // System.out.println(p+" "+q);
                src[i] = dest[q++];
            }
        }
    }

    // 自顶向下
    public static void MergeSortTB(int[] arr, int[] aux, int low, int high){
        if(low>=high) return;
        int mid = (low + high) >>> 1;
        MergeSortTB(arr, aux, low, mid);
        MergeSortTB(arr, aux, mid+1, high);
        if(arr[mid]<arr[mid+1])
            return;
        Merge(arr, aux, low, mid, high);
    }

    // 自底向上，只需合并，不用递归
    public static void MergeSortBU(int[] arr, int[] aux){
        int N=arr.length;
        for(int sz=1; sz<N; sz+=sz)  
            for(int low=0; low<N-sz; low += sz+sz)
                Merge(arr, aux, low, low+sz-1, Math.min(low+sz+sz-1, N-1));
    }

    public static void Merge(int[] arr, int[] aux, int low, int mid, int high){
        for(int i=low; i<=high; i++){
            aux[i] = arr[i];   // 把左右两端的值传给辅助数组
        }

        for(int i=low, p=low, q=mid+1; i<=high; i++){
            if(p>mid)                arr[i] = aux[q++];
            else if(q>high)          arr[i] = aux[p++];
            else if(aux[p]>aux[q])   arr[i] = aux[q++];
            else                     arr[i] = aux[p++];
        }
    }
}
