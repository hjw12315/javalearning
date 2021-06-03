import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.InvocationTargetException;

public class ClassLoaderDemo {
    public static void main(String\u005B\u005D args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException, SecurityException{
        ClassLoader cs = ClassLoader.getSystemClassLoader();
        System.out.println(cs);  //  AppClassLoader

        ClassLoader cs2 = cs.getParent();
        System.out.println(cs2); // PlatformClassLoader

        ClassLoader cs3 = cs2.getParent();
        System.out.println(cs3); // null

        Class<?> c = StudentCollection.class;
        Constructor<?> con = c.getDeclaredConstructor(String.class);
        con.setAccessible(true);
        Object obj = con.newInstance("小明");
        System.out.println(obj);  // StudentCollenction{Name=小明}

        Method method = c.getMethod("setName", String.class);
        method.invoke(obj, "小红");
        System.out.println(obj);  // StudentCollenction{Name=小红}

        // Integer集合添加字符串
        ArrayList<Integer> array = new ArrayList<>();
        Class cla = array.getClass();
        Method m = cla.getMethod("add", Object.class);  // add的参数是泛型
        m.invoke(array, "hello");
        System.out.println(array); // [hello]

        // 集合添加字符串
        Class<?> cls = ArrayList.class;
        Constructor<?> cons = cls.getConstructor();
        Object obja = cons.newInstance();
        Method m2 = cls.getMethod("add", Object.class);
        m2.invoke(obja, "world");
        System.out.println(obja); // [world]

        char ch = '\u03C0';
        System.out.println("\u03C0: " + ch);
        
        String greeting = "AHello";
        int cpCount = greeting.codePointCount(0, greeting.length()); // 5
        System.out.println(cpCount);
        System.out.println(greeting.codePointAt(greeting.offsetByCodePoints(0, 1)));
        System.out.println(Arrays.toString(greeting.codePoints().toArray()));
        System.out.println(new String(greeting.codePoints().toArray(), 0, greeting.codePoints().toArray().length));

    }
}
