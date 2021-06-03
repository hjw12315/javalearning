import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteData{
	public static void main(String[] args) throws Exception{
		File file = new File("score.txt");
		if(file.exists()){
			System.out.println("File already exists");
			//System.exit(0);
		}
		
		PrintWriter pw = new PrintWriter(file);
		pw.print("John T Smith ");
		pw.println(90);
		pw.print("Eric K Jones ");
		pw.println(85);
		
		pw.close();
		
		Scanner output = new Scanner(file);
		while(output.hasNext()){
			String firstName = output.next();
			String mi = output.next();
			String lastName = output.next();
			int score = output.nextInt();
			System.out.println(firstName+" "+mi+" "+lastName+" "+score);
		}
		output.close();
	}
}