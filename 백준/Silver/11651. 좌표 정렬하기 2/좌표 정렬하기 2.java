import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		List<Node> list = new ArrayList<>();
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < list.size() ; i++) {
			sb.append(list.get(i).x + " " + list.get(i).y).append("\n");
		}
		
		System.out.print(sb);
		
	}
	
	static class Node implements Comparable<Node>{
		
		int x;
		int y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			
			if(this.y == o.y) {
				return this.x - o.x;
			}
			return this.y - o.y;
		}
	}
}