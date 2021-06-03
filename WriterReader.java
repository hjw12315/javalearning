import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class WriterReader {
    public static void main(String[] args) throws IOException{
        // 指定编码为GBK，也可以使用默认编码
        // OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("WriterReader.txt"), "GBK");
        BufferedWriter out = new BufferedWriter(new FileWriter("WriterReader.txt"));
        out.write("新年快乐！");
        out.write(97);
        char[] chs = {'b', 'c', 'd'};
        out.write(chs);
        // out.flush();
        out.close();

        //InputStreamReader in = new InputStreamReader(new FileInputStream("WriterReader.txt"), "GBK");
        BufferedReader in = new BufferedReader(new FileReader("WriterReader.txt"));
        char[] c = new char[1024];
        int DateLen;
        while((DateLen=in.read(c))!=-1)                    // read()、read(char[] c)
            System.out.println(new String(c, 0, DateLen)); // 每次读取字符数组长度个字符
            // System.out.println((char)readDate);          // 每次读取一个字符
        in.close();
    }
}
