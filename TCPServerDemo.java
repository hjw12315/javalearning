import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerDemo {
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(8888);

        while(true){
            // 监听
            Socket s = ss.accept(); 
            // 为每个连接对象创建一个线程
            new Thread(new SocketThread(s)).start();;
        }

        // // InputStream is = s.getInputStream();
        // BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        // // byte[] bys = new byte[1024];
        // // int len = is.read(bys);
        // // System.out.println("服务器接收: " + new String(bys, 0, len));
        // String date;
        // while((date=br.readLine())!=null){
        //     System.out.println("服务器接收: " + date);
        // }

        // OutputStream os = s.getOutputStream();
        // os.write("hello--来自服务器端".getBytes());

        // ss.close();
    }
}

class SocketThread implements Runnable{
    private Socket s;

    public SocketThread(Socket s){
        this.s = s;
    }

    @Override
    public void run(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        
            String date;
            while((date=br.readLine())!=null){
                System.out.println("服务器接收数据: " + date);
            }

            OutputStream os = s.getOutputStream();
            os.write("来自服务器端的反馈".getBytes());
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            try{
                s.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
