import java.util.Properties;
import java.util.Set;
import java.io.PrintStream;

public class PropertiesDemo{
    public static void main(String[] args){
        Properties p = new Properties();
        p.put("001", "林青霞");
        p.setProperty("002", "张曼玉");
        p.setProperty("003", "王祖贤");

        PrintStream ps = System.out;
        //Set<Object> key = p.keySet();
        Set<String> key = p.stringPropertyNames();
        for(String k : key)
            ps.println(p.getProperty(k));
    }
}