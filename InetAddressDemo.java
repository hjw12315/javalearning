import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException{
        InetAddress address = InetAddress.getByName("LAPTOP-SR9G5REM");
        System.out.println(address);
        System.out.println("HostName: " + address.getHostName());
        System.out.println("HostAddress: " + address.getHostAddress());
    }
}
