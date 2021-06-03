import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPTransFileClient {
    private static Socket s;
    private static BufferedReader br;
    private static BufferedWriter bw;
    public static void main(String[] args) {
        try{
            s = new Socket("172.26.110.248", 8888);

            bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(new FileInputStream("sqrt.java")));

            String date;
            while((date=br.readLine())!=null){
                bw.write(date);
                bw.newLine();
                bw.flush();
            }

            s.shutdownOutput();

            BufferedReader brc = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String back = brc.readLine();
            System.out.println(back);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            try{
                br.close();
                s.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
