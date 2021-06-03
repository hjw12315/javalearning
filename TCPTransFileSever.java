import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPTransFileSever {
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(8888);

        while(true){
            Socket s = ss.accept();
            new Thread(new SocketFileThread(s)).start();
        }
    }
}

class SocketFileThread implements Runnable{
    private Socket s;
    private static int flag;  // 非静态的可以访问静态的，但是静态的不能访问非静态的
    private BufferedReader br;
    private BufferedWriter bw;
    public SocketFileThread(Socket s){
        this.s = s;
    }

    @Override
    public void run(){
        try{
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            File file = new File("sqrt"+flag+".java");
            // 为什么要用while，不能用if，flag要定义为static
            if(file.exists()){
                System.out.println(flag);
                flag++;
                file = new File("sqrt"+flag+".java");
            }
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

            String date;
            while((date=br.readLine())!=null){
                bw.write(date);
                bw.newLine();
                bw.flush();
            }

            BufferedWriter bws = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bws.write("文件传输完成");
            bws.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            try{
                bw.close();
                s.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
