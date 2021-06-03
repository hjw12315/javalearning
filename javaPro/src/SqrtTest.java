import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class SqrtTest {
    // 申请资源，用于所有测试执行之前
    @Before
    public void init(){
        System.out.println("init");
    }

    @Test
    public void testSqrt(){
        double result = Sqrt.sqrt1(4);
        System.out.println("test");
        Assert.assertEquals(2.0, result, 0.001);
    }

    // 释放资源，在所有的测试方法执行完之后执行
    @After
    public void close(){
        System.out.println("close");
    }
}
