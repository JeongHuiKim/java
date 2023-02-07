import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		
		char[] ch = in.readLine().toCharArray();
		
		double[] num = new double[N];
		
		for(int i = 0 ; i < N ; i++) {
			num[i] = Integer.parseInt(in.readLine());
		}
		
		Stack<Double> stack = new Stack<>();
		
		for(char c : ch) {
			double num1;
			double num2;
			switch(c) {
			case '+':
				stack.push(stack.pop() + stack.pop());
				break;
			case '-':
				num1 = stack.pop();
				num2 = stack.pop();
				stack.push(num2 - num1);
				break;
			case '*':
				stack.push(stack.pop() * stack.pop());
				break;
			case '/':
				num1 = stack.pop();
				num2 = stack.pop();
				stack.push(num2 / num1);
				break;
			default:
				stack.push(num[c - 'A']);
			}
		}
		
		System.out.printf("%.2f\n",stack.pop());

	}	
}