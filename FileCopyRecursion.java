import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyRecursion {
    public static void main(String[] args) throws IOException{
        File src = new File("E:\\A-paper");
        //String dirName = src.getName();
        File dest = new File("E:\\Google");
        copyFile(src, dest);
    }

    public static void copyFile(File src, File dest) throws IOException{
        if(src.isFile()){
            File destFile = new File(dest, src.getName());
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
            byte[] by = new byte[1024];
            int len;
            while((len=bis.read(by))!=-1){
                bos.write(by, 0, len);
                bos.flush();
            }
            bis.close();
            bos.close();
        }
        else{
            String dirName = src.getName();
            File dir = new File(dest, dirName); // 为子目录新建一个对象
            if(!dir.exists())
                dir.mkdir();
            File[] files = src.listFiles();
            for(File file: files){
                copyFile(file, dir);  // dir是目录
            }
        }
    }
}
