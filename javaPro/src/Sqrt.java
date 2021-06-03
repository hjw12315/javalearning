public class Sqrt{
	public static double sqrt1(double c){
		if(c<0) return Double.NaN;
		double err = 1e-15;
		double t = c;
		while(Math.abs(t-c/t)>err*t){
			t = (t+c/t) / 2.0;
		}
		return t;
	}
	
	public static double sqrt2(double c){
		if(c<0) return Double.NaN;
		double err = 1e-15;
		double t = c;
		while((t*t-c)>err){
			t += (c-t*t)/(2*t);
		}
		return t;
	}
	
	public static void main(String[] args){
		double s1 = sqrt1(5);
		System.out.println(s1);
		double s2 = sqrt2(5);
		System.out.println(s2);

	}
}