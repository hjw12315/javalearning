package exceptions;

class SimpleException extends Exception{}

public class InheritingExceptions {
    public void f() throws SimpleException{
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }
    public void g() throws SimpleException{
        f();
    }
    public static void main(String[] args){
        InheritingExceptions ie = new InheritingExceptions();
        try{
            ie.g();
        }
        catch (SimpleException se){
            System.out.println("catch it");
            se.printStackTrace();
        }

        try{
            throw new RuntimeException();  // 抛出了异常也不会被catch
        }finally {
            return;
        }
    }
}
