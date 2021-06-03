package enumerated;

enum lightColor {RED, GREEN, YELLOW}

public class TrafficLight{
    private lightColor color = lightColor.RED;
    public void change(){
        switch (color){
            case RED:
                System.out.println("RED");
                color = lightColor.GREEN;
                break;
            case GREEN:
                System.out.println("GREEN");
                color = lightColor.YELLOW;
                break;
            case YELLOW:
                System.out.println("YELLOW");
                color = lightColor.RED;
                break;
        }
    }
    public static void main(String[] args){
        TrafficLight tlight = new TrafficLight();
        for(int i=0; i<7; i++)
            tlight.change();
    }
}
