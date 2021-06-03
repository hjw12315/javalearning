import java.lang.reflect.Field;

public class MyAnnoTest {
    public static void main(String[] args) throws SecurityException,IllegalArgumentException, IllegalAccessException{
        MyAnnoStringTest mat = new MyAnnoStringTest();
        mat.s1 = "123";
        mat.s2 = "";
        mat.s3 = "";
        for(Field field: mat.getClass().getFields()){
            // 判断字段是否被MyAnno注解
            if(field.isAnnotationPresent(MyAnno.class)){
                // 获取注解对象，以便调用注解的方法
                MyAnno mo = field.getAnnotation(MyAnno.class);

                Object value = field.get(mat);
                if(value instanceof String){
                    String s = (String)value;
                    if(s.length()<mo.Min() || s.length()>mo.Max())
                        throw new IllegalArgumentException("Invalid Field: " + field.getName());
                }
            }
        }
    }
}
