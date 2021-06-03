import java.util.Scanner;
import javax.swing.JFileChooser;

public class ReadFileUsingJFileChooser{
	
	public static void main(String[] args) throws Exception{
		
		JFileChooser filechooser = new JFileChooser();
		
		if(filechooser.showOpenDialog(null)
		== JFileChooser.APPROVE_OPTION){
			java.io.File file = filechooser.getSelectedFile();
			Scanner scan = new Scanner(file);
			
			while(scan.hasNext()){
				System.out.println(scan.nextLine());
			}
			
			scan.close();
		}
		else{
			System.out.println("No file selected");
		}
	}
}