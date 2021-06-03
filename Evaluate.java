import java.util.Scanner;
import java.util.Stack;

public class Ca{
	public static void main(String[] args){
		StackOfLinkList<String> ops = new StackOfLinkList<String>();
		StackOfLinkList<Double> vals = new StackOfLinkList<Double>();
		// Stack<String> ops = new Stack<String>();
		// Stack<Double> vals = new Stack<Double>();
		
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.next();
			if(str.equals("end")) break;
			else if(str.equals("("))              ;
			else if(str.equals("+")) ops.push(str);
			else if(str.equals("-")) ops.push(str);
			else if(str.equals("*")) ops.push(str);
			else if(str.equals("/")) ops.push(str);
			else if(str.equals("sqrt")) ops.push(str);
			else if(str.equals(")")){
				String op = ops.pop();
				double v = vals.pop();
				if(op.equals("+"))      v = vals.pop() + v;
				else if(op.equals("-")) v = vals.pop() - v;
				else if(op.equals("*")) v = vals.pop() * v;
				else if(op.equals("/")) v = vals.pop() / v;
				else if(op.equals("sqrt")) v = Math.sqrt(v);
				vals.push(v);
			}
			else vals.push(Double.parseDouble(str));
		}
		input.close();
		System.out.println(vals.pop());
	}
}