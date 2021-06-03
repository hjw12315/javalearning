public class MyAnnoStringTest {
    // 在要测试的字段上加注解
    @MyAnno(Min = 3, Max = 5)
    public String s1;

    @MyAnno
    public String s2;

    public String s3;
}
