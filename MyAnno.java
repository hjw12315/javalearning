import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME) //表示注解会被保留到字节码文件中，并被jvm读取
@Documented
@Inherited
public @interface MyAnno {
    int Min() default 1;
    int Max() default 10; 
}
