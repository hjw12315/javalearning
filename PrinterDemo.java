public class PrinterDemo {
    public static void main(String[] args){
        // lambda实现接口方法，是通过对PrintString中的printUpper方法的调用来实现
        usePrinter(s->System.out.println(s.toUpperCase()));

        // 对象名::实例方法名，引用对象的实例方法
        PrintString ps = new PrintString();
        usePrinter(ps::printUpper);
    }

    public static void usePrinter(Printer p){
        p.printUpperCase("abc");   // 调用接口方法
    }
}
