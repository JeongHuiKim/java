import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		
		PriorityQueue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0 ; i < N ; i++) {
			
			int num = Integer.parseInt(in.readLine());
			
			if(num == 0) {
				if(priority.isEmpty()) {
					sb.append("0\n");
				}
				else {
					sb.append(priority.poll()).append("\n");
				}
			}
			else {
				priority.add(num);
			}			
		}
		
		System.out.print(sb);
	}
	
	
	
}