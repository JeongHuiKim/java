import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		
		for(int test_case = 0 ; test_case < T ; test_case++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			
			Queue<Node> queue = new LinkedList<>();
			
			List<Integer> rank = new ArrayList<>();
			
			st = new StringTokenizer(in.readLine());
			for(int i = 0 ; i < N ; i++) {
				int num =Integer.parseInt(st.nextToken());
				queue.add(new Node(i,num));
				rank.add(num);
			}
			
			Collections.sort(rank, Comparator.reverseOrder());
			
			int count = 0;
			
			while(true) {
				
				
				if(queue.peek().rank != rank.get(0)) {
					queue.add(queue.poll());
				}
				else {
					if(queue.peek().index == index) {
						sb.append(++count).append("\n");
						break;
					}
					queue.poll();
					rank.remove(0);
					count++;
				}
			}
		}
		
		System.out.print(sb);
		
	}	
	
	static class Node{
		int index;
		int rank;
		
		Node(int index, int rank){
			this.index = index;
			this.rank = rank;
		}
	}
}