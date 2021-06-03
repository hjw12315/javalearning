import java.util.Arrays;

public class StaticInnerClassDemo {
    public static void main(String[] args){
        double[] arr = new double[10];
        for(int i=0; i<arr.length; i++){
            arr[i] = Math.random();
        }
        System.out.println(Arrays.toString(arr));

        OuterClassTest.StaticInner ics = OuterClassTest.MinMax(arr);
        System.out.println("Max value: " + ics.getFirst());
        System.out.println("Min value: " + ics.getSecond());


        // 内部类与静态内部类
        StaticInnerClassDemo sic = new StaticInnerClassDemo();
        StaticInnerClassDemo.InnerClass ic = sic.new InnerClass(); // 要通过外部类对象调用

        InnerStaticClass isc = new InnerStaticClass(); // 直接new
    }

    public class InnerClass{}
    public static class InnerStaticClass{}
}

class OuterClassTest{

    public static class StaticInner {
        private double first;
        private double second;
        public StaticInner(double first, double second) {
            this.first = first;
            this.second = second;
        }
        public double getFirst() {return first;}
        public double getSecond() {return second;}
    }

    public static StaticInner MinMax(double[] arr){
        double min = arr[0];
        double max = arr[0];
        for(double i: arr){
            if(i>max) max = i;
            if(i<min) min = i;
        }

        return new StaticInner(max, min);
    }
}
