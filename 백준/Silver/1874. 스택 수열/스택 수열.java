import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		int pushedNum = 0;
		
		for(int i = 0 ; i < N ; i++) {
			
			int num = Integer.parseInt(in.readLine());
			
			if(num > pushedNum) {
				for(int j = pushedNum+1 ; j <= num ; j++) {
					stack.push(j);
					sb.append("+\n");
				}
				pushedNum = num;
				stack.pop();
				sb.append("-\n");
			}
			else {
				if(num != stack.pop()) {
					System.out.println("NO");
					return;
				}
				else {
					sb.append("-\n");
				}
			}
		}
		System.out.print(sb);
	}
}