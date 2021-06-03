import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo {
    public static void main(String[] args) throws IOException{
        DatagramSocket dgs = new DatagramSocket();

        byte[] bys = "hello".getBytes();
        // 将数据打包，并制定IP地址和端口号
        DatagramPacket p = new DatagramPacket(bys, bys.length, InetAddress.getByName("192.168.0.197"), 8888);
    
        dgs.send(p);
        dgs.close();
    }
}
