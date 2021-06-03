import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo {
    public static void main(String[] args) throws IOException, FileNotFoundException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Properties p = new Properties();
        FileReader fr = new FileReader("reflect.txt"); 
        p.load(fr);
        fr.close();

        // reflect.txt
        // ClassName="StudentCollection"
        // MethodName="printInfo"
        String className = p.getProperty("ClassName");
        String methodName = p.getProperty("MethodName");

        Class<?> cls = Class.forName(className);  // className要是一个完整的包才行
        Constructor<?> con = cls.getConstructor();
        Object obj = con.newInstance();

        Method method = cls.getMethod(methodName);
        method.invoke(obj);

    }
}
