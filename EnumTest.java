import java.util.Scanner;

public class EnumTest{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
		String in = input.next().toUpperCase();
		Size s = Enum.valueOf(Size.class, in); //将输入的in变为枚举实例
		System.out.println("size=" + s);
		System.out.println("abbreviation=" + s.getAbbreviation()); 
		Size[] size = Size.values();
		for(Size i:size)
			System.out.println(i);
		if(s==s.EXTRA_LARGE)
			System.out.println("Good job--you paid attention to the _.");
	}
}

enum Size{
	SMALL("S"), MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL"); //只能有这4个实例，不能创建新实例
	
	private String abbreviation;
	private Size(String abbreviation){
		this.abbreviation = abbreviation;
	}
	public String getAbbreviation(){
		return abbreviation;
	}
}