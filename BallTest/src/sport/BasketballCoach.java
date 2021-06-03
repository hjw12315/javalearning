package sport;

public class BasketballCoach extends coach {
    public BasketballCoach(){}
    public BasketballCoach(String name, int age){
        super(name, age);
    }

    @Override
    public void teaching(){
        System.out.println("篮球教练教篮球");
    }

    @Override
    public void eating(){
        System.out.println("篮球运动员吃汤圆");
    }
}
