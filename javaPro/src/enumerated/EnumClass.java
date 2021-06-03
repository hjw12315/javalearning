package enumerated;

enum Shrubbery { GROUND, CRAWLING, HANGING }  // enum是一个关键字 Enum是一个类

public class EnumClass {
    public static void main(String[] args){
        for(Shrubbery s: Shrubbery.values()){  // 获取里面的对象
            System.out.println(s + " ordinal: " + s.ordinal());  // 获取顺序
            System.out.print(s.compareTo(Shrubbery.CRAWLING) + " ");
            System.out.print(s.equals(Shrubbery.CRAWLING) + " ");
            System.out.println(s==Shrubbery.CRAWLING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("--------------------");
        }
        for(String s:"HANGING CRAWLING GROUND".split(" ")){
            Shrubbery e = Enum.valueOf(Shrubbery.class, s);
            System.out.println(e);
        }
    }
}
