package sport;

public abstract class coach extends Person {
    public coach(){}
    public coach(String name, int age){
        super(name, age);
    }

    public abstract void teaching();
}
