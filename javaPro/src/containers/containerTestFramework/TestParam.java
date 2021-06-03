package containers.containerTestFramework;

// 设置参数
public class TestParam {
    public final int size;
    public final int loops;
    public TestParam(int size, int loops){
        this.size = size;
        this.loops = loops;
    }
    public static TestParam[] array(int...values){
        int size = values.length/2;
        TestParam[] tp = new TestParam[size];
        int n=0;
        for(int i=0; i<size; i++){
            // 返回多个参数对象，容器的大小，测试的轮数
            tp[i] = new TestParam(values[n++], values[n++]);
        }
        return tp;
    }
    // 用于接收命令行参数
    public static TestParam[] array(String[] values){
        int[] vals = new int[values.length];
        for(int i=0; i<vals.length; i++){
            vals[i] = Integer.decode(values[i]);  // 将字符串中的整数解码为一个Integer
        }
        return array(vals);
    }
}
