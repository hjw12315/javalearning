import java.util.PriorityQueue;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 优先队列归并排序，把每一路数据都保存到一个优先队列中
 * 
 */

public class MultiWaySorted {
    private static void merge(MaxPQ<String> mpq){
        while(!mpq.isEmpty()){
            System.out.print(mpq.delMax() + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args){
        String[] arg = {"m1.txt", "m2.txt", "m3.txt"};
        int N = arg.length;
        MaxPQ<String> mpq = new MaxPQ<>();
        BufferedInputStream bis = null;
        for(int i=0; i<N; i++){
            try{
                bis = new BufferedInputStream(new FileInputStream(arg[i]));
                byte[] bys = new byte[1024];
                int len;
                while((len=bis.read(bys))!=-1){
                    for(String s: new String(bys, 0, len).split(" ")){
                        mpq.insert(s);
                    }
                }
            }
            catch(IOException io){
                io.printStackTrace();
            }
            finally{
                if(bis!=null)
                    try{
                        bis.close();
                    }
                    catch(IOException io){
                        io.printStackTrace();
                    }
            }
        }
        mpq.printArr();
        merge(mpq);
    }
}
