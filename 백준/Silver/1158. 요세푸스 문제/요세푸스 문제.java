import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();
		
		sb.append("<");
		
		for(int i = 1 ; i <= N ; i++) {
			queue.add(i);
		}
		
		while(true) {
			if(queue.size() == 1) {
				sb.append(queue.poll() + ">");
				break;
			}
			for(int i = 0 ; i < K-1 ; i++) {
				queue.add(queue.poll());
			}
			sb.append(queue.poll() + ", ");
		}
		
		System.out.println(sb);
		
	}
	
	
}