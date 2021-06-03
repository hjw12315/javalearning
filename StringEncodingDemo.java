import java.util.Arrays;
import java.io.UnsupportedEncodingException;

public class StringEncodingDemo {
    public static void main(String[] args) throws UnsupportedEncodingException{
        String s = "中国";

        byte[] by = s.getBytes();  // 使用默认编码 UTF-8
        byte[] by2 = s.getBytes("GBK");
        System.out.println(Arrays.toString(by));
        System.out.println(Arrays.toString(by2));

        String s1 = new String(by);
        System.out.println(s1);
        String s2 = new String(by, "UTF-8");
        System.out.println("Decoding by UTF-8: " + s2);
        String s3 = new String(by, "GBK");
        System.out.println("Decoding by GBK: " + s3);
    }
}
