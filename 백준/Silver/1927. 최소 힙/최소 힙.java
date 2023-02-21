import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		int N = Integer.parseInt(in.readLine());
		
		for(int i = 0 ; i < N ; i++) {
			
			int input = Integer.parseInt(in.readLine());
			
			if(input == 0) {
				if(queue.isEmpty()) {
					sb.append("0\n");
				}
				else {
					sb.append(queue.poll() + "\n");
				}
			}
			else {
				queue.add(input);
			}
		}
		
		System.out.print(sb);
	}
}