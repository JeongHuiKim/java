import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
//		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0 ; i < N ; i++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			for(int j = 0 ; j < N ; j++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int num = 0;
		for(int i = 0 ; i < N ; i++) {
			num = queue.poll();
		}
		
		
		System.out.println(num);
	}
	
	
	
}