import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args){
        // FileOutputStream fileOut = null;
        BufferedOutputStream fileOut = null;  // 提供一个缓冲区
        try{
            // fileOut = new FileOutputStream("FileOutputStream.txt", true);  // true表示可以追加
            fileOut = new BufferedOutputStream(new FileOutputStream("FileOutputStream.txt", true));
            for(int i=0; i<10; i++){
                fileOut.write("abcde".getBytes()); // 将字符串编码成字节数组
                fileOut.write("\n".getBytes());
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            if(fileOut!=null){  // 防止文件不存在
                try{
                    fileOut.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }

        BufferedInputStream fileIn = null;
        try{
            fileIn = new BufferedInputStream(new FileInputStream("FileOutputStream.txt"));
            byte[] b = new byte[1024];        // 每次读取1024个字节到字节数组b
            int len;
            while((len=fileIn.read(b))!=-1){  // 读完之后最终返回-1
                System.out.println(new String(b, 0, len));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            if(fileIn != null){
                try{
                    fileIn.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }   
    }
}
