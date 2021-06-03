public class TestRational{
	public static void main(String[] args){
		Rational r1 = new Rational("3","4");
		Rational r2 = new Rational("5","6");
		
		System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
		System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
		System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
		System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
		System.out.println(r1.compareTo(r2));
		
		Rational r3 = new Rational("1", "923123123123456789");
		Rational r4 = new Rational("1", "923456789");
		Rational r5 = new Rational("1", "923456789");
		System.out.println(r3 + " * " + r4 + " * " + r5 + " = " + r3.multiply(r4.multiply(r5)));
	}
}