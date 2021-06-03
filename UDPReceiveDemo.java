import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiveDemo{
    public static void main(String[] args) throws IOException{
        DatagramSocket dgs = new DatagramSocket(8888);
        byte[] buf = new byte[1024];
        // 接收数据
        DatagramPacket p = new DatagramPacket(buf, buf.length);
        dgs.receive(p);

        System.out.println("Port:" + p.getPort());
        System.out.println("Address: " + p.getAddress());
        byte[] br = p.getData();
        System.out.println(new String(br, 0, p.getLength()));
        dgs.close();
    }
}