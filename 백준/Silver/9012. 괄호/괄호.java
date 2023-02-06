import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		for(int test_case = 0 ; test_case < N ; test_case++) {
			char[] input = in.readLine().toCharArray();
			
			Stack<Character> stack = new Stack<>();
			
			for(int i = 0 ; i < input.length ; i++) {
				if(stack.isEmpty()) {
					stack.push(input[i]);
				}
				else {
					if(stack.peek() == '(' && input[i] == ')') {
						stack.pop();
					}
					else {
						stack.push(input[i]);
					}
				}
			}
			
			if(stack.isEmpty()) {
				sb.append("YES\n");
			}
			else {
				sb.append("NO\n");
			}
		}
		
		System.out.print(sb);

		
	}
}