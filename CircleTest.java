public class CircleTest {
    public static void main(String[] args) {
        Circle c = new Circle();
        try{
            c.setRadius(-1.0);
        }catch(InvalidRadiusException e){
            e.printStackTrace();
        }
    }
}

class Circle{
    private double radius;

    public void setRadius(double r) throws InvalidRadiusException{
        if(r<0)
            throw new InvalidRadiusException("半径不能为负数");
        else
            radius = r;
        
    }
}
