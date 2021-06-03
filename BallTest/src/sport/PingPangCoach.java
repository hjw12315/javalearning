package sport;

public class PingPangCoach extends coach implements speakEnglish{
    public PingPangCoach(){}
    public PingPangCoach(String name, int age){
        super(name, age);
    }
    @Override
    public void teaching(){
        System.out.println("乒乓球教练" + getName() + "教乒乓球");
    }

    @Override
    public void eating(){
        System.out.println("乒乓球教练" + getName() + "吃饺子");
    }

    @Override
    public void speak(){
        System.out.println("乒乓球教练" + getName() + "说英语");
    }
}
