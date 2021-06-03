package generator;

import java.util.*;

// 随机数生成器
public class RandomGenerator {
    private static Random r = new Random(47);
    public static class Boolean implements Generator<java.lang.Boolean>{
        public java.lang.Boolean next(){
            return r.nextBoolean();
        }
    }

    public static class Byte implements Generator<java.lang.Byte>{
        public java.lang.Byte next(){
            return (byte)r.nextInt();
        }
    }

    public static class Character implements Generator<java.lang.Character>{
        public java.lang.Character next(){
            return CountingGenerator.chars[r.nextInt(CountingGenerator.chars.length)];
        }
    }

    public static class String extends CountingGenerator.String{
        {cg = new Character();}
        public String(){}
        public String(int length){super(length);}
    }

    public static class Short implements Generator<java.lang.Short>{
        public java.lang.Short next(){
            // short两个字节，int四个字节
            return (short)r.nextInt(java.lang.Short.MAX_VALUE);  // 生成正值
        }
    }

    public static class Integer implements Generator<java.lang.Integer>{
        private int mod = 10000;
        public Integer(){}
        public Integer(int module){mod = module;}
        public java.lang.Integer next(){
            return r.nextInt(mod);
        }
    }

    public static class Long implements Generator<java.lang.Long>{
        public java.lang.Long next(){
            return r.nextLong();
        }
    }

    public static class Float implements Generator<java.lang.Float>{
        public java.lang.Float next(){
            return r.nextFloat();
        }
    }

    public static class Double implements Generator<java.lang.Double>{
        public java.lang.Double next(){
            long trimmed = Math.round(r.nextDouble() * 100);
            return (double)trimmed / 100;
        }
    }
}
