import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClientDemo {
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("192.168.0.197", 8888);
        // OutputStream os = s.getOutputStream();
        // os.write("hello".getBytes());
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        // 字节流封装到字符流
        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String date;
        while((date=read.readLine())!=null){
            if(date.equals("bye")){
                // write.write("bye");
                // write.newLine();
                // write.flush();
                s.shutdownOutput();
                break;
            }
            write.write(date);
            write.newLine();
            write.flush();
        }

        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
    
        System.out.println("客户端接收: " + new String(bys, 0, len));

        s.close();
    }
}
