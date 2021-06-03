import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.util.ArrayList;

import javax.sound.midi.SysexMessage;
import javax.swing.JOptionPane;

import java.math.BigInteger;

public class Test{
	
	int i = 5;
	static int j = 1;
	
	public static void main(String[] args){

		// System.getProperties().list(System.out);
		// System.out.println(System.getProperty("user.name"));
		// System.out.println(System.getProperty("java.library.path"));

		float bb = 'a';
		System.out.println(bb);  // 97.0
		
		System.out.println(1.0/0);

		Random r = new Random();
		System.out.printf("%b\n", r.nextBoolean());
		
		String s = "abcdefg".replace("de","ed");
		System.out.printf("%s\n", s);
			
		byte b = (byte)'\uFFF4';
		String input = JOptionPane.showInputDialog(null, 
												"Enter an input","Input Dialog Demo", 
												JOptionPane.QUESTION_MESSAGE);
		int ch = Integer.parseInt(input); 
		int out;
		out = ch + b;
		System.out.println(out);
		
		Redirected();
		System.out.println("\n" + (char)('a' + Math.random()*('z'-'a'+1))); // generate a random letter
		
	}
	
	public static void Redirected(){  // static method
			Scanner scan = new Scanner(System.in);
			int data = scan.nextInt();
			int sum = 0;
			while(data!=0){
				sum += data;
				data = scan.nextInt();
			}
			System.out.printf("the sum is: %d", sum);
		}
 
}