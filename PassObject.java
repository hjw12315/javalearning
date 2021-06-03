public class PassObject{

	public static void main(String[] args){
		PassObject pas = new PassObject();
		Circle cir = new Circle();
		pas.printAreas(cir, 5);
	}
	public void printAreas(Circle c, int time){
		for(int i=1; i<=time; i++){
			c.setRadius(i);
			System.out.println(c.getRadius() +"         "+ c.findArea());
		}
		
	}
}