package sport;

public class BasketballSporter extends sporter{
    public BasketballSporter(){}
    public BasketballSporter(String name, int age){
        super(name, age);
    }

    @Override
    public void eating(){
        System.out.println("篮球运动员吃米饭");
    }

    @Override
    public void learning(){
        System.out.println("篮球运动员学英语");
    }
}
