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
		
		int dp[] = new int[N];
		
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());	
			list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list);
		
		dp[0] = 1;
		
		for(int i = 1 ; i < N ; i++) {
			dp[i] = 1;
			for(int j = 1 ; j <= i ; j++) {
				if( list.get(i-j).y < list.get(i).y ) {
					dp[i] = Math.max(dp[i], dp[i-j] + 1);
				}
			}
		}
		
		int max = 0;
		for(int i = 0 ; i < N ; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(N-max);
	}
}

class Node implements Comparable<Node>{
	
	int x;
	int y;
	
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.x - o.x;
	}
	
}