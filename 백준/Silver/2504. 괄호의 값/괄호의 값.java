import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		Stack<String> stack = new Stack<>();
		char[] input = in.readLine().toCharArray();
		

		for(int i = 0 ; i < input.length ; i++) {
//			System.out.println(stack.toString());
			int num = 0;
			switch(input[i]) {
			case ')':
//				System.out.println("case ) : " + stack.toString());
				while( !stack.isEmpty() && (!stack.peek().equals("(") && !stack.peek().equals("["))) {
//					num += stack.pop() - '0';
					num += Integer.parseInt(stack.pop());
				}
				num = num == 0 ? 1 : num;

				if( !stack.isEmpty() && stack.pop().equals("(")) {
//					stack.push( (char) (2*num + '0'));
					stack.push( "" + 2*num );
				}
				else {
					System.out.println(0);
					return;
				}
				break;
			case ']':
//				System.out.println("case ] : " + stack.toString());
				while( !stack.isEmpty() && (!stack.peek().equals("(") && !stack.peek().equals("["))) {
//					num += stack.pop() - '0';
					num += Integer.parseInt(stack.pop());
				}
				num = num == 0 ? 1 : num;

				if(!stack.isEmpty() && stack.pop().equals("[")) {
//					stack.push( (char) (3*num + '0'));
					stack.push( "" + 3*num );
				}
				else {
					System.out.println(0);
					return;
				}
				break;
			default:
				stack.push(String.valueOf(input[i]));
				break;
			}
		}
		
		int total = 0;
		while(!stack.isEmpty()) {
			if(stack.peek().equals("(") || stack.peek().equals("[")) {
				System.out.println(0);
				return;
			}
//			total += stack.pop() - '0';
			total += Integer.parseInt(stack.pop());
		}
		System.out.println(total);


	}
}