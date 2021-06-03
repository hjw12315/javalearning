package sport;

public class PingPangSport extends sporter implements speakEnglish{
    public PingPangSport(){}
    public PingPangSport(String name, int age){
        super(name, age);
    }

    @Override
    public void speak(){
        System.out.println("乒乓球运动员说英语");
    }

    @Override
    public void eating(){
        System.out.println("乒乓球运动员吃牛肉");
    }

    @Override
    public void learning(){
        System.out.println("乒乓球运动员学英语");
    }
}
