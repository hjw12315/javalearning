import java.math.*;

public class Rational extends Number implements Comparable{
	private BigInteger numerator;
	private BigInteger denominator;
	
	public Rational(){
		this("0","1");
	}
	public Rational(String n, String d){
		BigInteger numerator = new BigInteger(n);
		BigInteger denominator = new BigInteger(d);
		BigInteger g = gcd(numerator, denominator);
		this.numerator = numerator.divide(g);
		this.denominator = denominator.divide(g);
	}
	
	public BigInteger getNumerator(){
		return numerator;
	}
	public BigInteger getDenominator(){
		return denominator;
	}
	
	public Rational add(Rational secondRational){
		BigInteger n = numerator.multiply(secondRational.getDenominator()).add(denominator.multiply(secondRational.getNumerator()));
		BigInteger d = denominator.multiply(secondRational.getDenominator());
		return new Rational(n.toString(), d.toString());  // 返回一个新的对象
	}
	
	public Rational subtract(Rational secondRational){
		BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(denominator.multiply(secondRational.getNumerator()));
		BigInteger d = denominator.multiply(secondRational.getDenominator());
		return new Rational(n.toString(), d.toString());
	}
	
	public Rational multiply(Rational secondRational){
		BigInteger n = numerator.multiply(secondRational.getNumerator());
		BigInteger d = denominator.multiply(secondRational.getDenominator());
		return new Rational(n.toString(), d.toString());
	}
	
	public Rational divide(Rational secondRational){
		BigInteger n = numerator.multiply(secondRational.getDenominator());
		BigInteger d = denominator.multiply(secondRational.getNumerator());
		return new Rational(n.toString(), d.toString());
	}
	
	public String toString(){
		if(denominator==BigInteger.ONE)
			return numerator + "";
		else
			return numerator + "/" + denominator;
	}
	
	// 找最大公约数
	private static BigInteger gcd(BigInteger numerator, BigInteger denominator){
		BigInteger n = numerator.abs();
		BigInteger d = denominator.abs();
		BigInteger g = BigInteger.ONE;
		/*
		for(int i=2; i<=((n>d) ? d : n); i++){
			if(n%i==0 && d%i==0)
				g = i;
		}*/
		g = n.gcd(d);
		return g;
	}
	
	public double doubleValue(){  // 这些是抽象方法，必须重写
		return numerator.divide(denominator).doubleValue();
	}
	public float floatValue(){
		return (float)doubleValue();
	}
	public int intValue(){
		return (int)doubleValue();
	}
	public long longValue(){
		return (long)doubleValue();
	}
	public int compareTo(Object o){
		/*
		if((this.subtract((Rational)o)).getNumerator() > 0)
			return 1;
		else if((this.subtract((Rational)o)).getNumerator() == 0)
			return 0;
		else 
			return -1;
		*/
		return (this.subtract((Rational)o)).getNumerator().signum();
	}
}