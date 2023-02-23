import java.util.*;
import java.io.*;

public class Main {
	
    static int[] visit = new int[100001];
    
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dfs(N, K);
	}
	
	static void dfs(int N , int K) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		visit[N] = 1;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			if(x == K) {
				break;
			}
			if(x-1 >= 0 && visit[x-1] == 0) {
				queue.add(x-1);
				visit[x-1] = visit[x] + 1;
			}
			if(x+1 <= 100000 && visit[x+1] == 0) {
				queue.add(x+1);
				visit[x+1] = visit[x] + 1;
			}
			if(x * 2 <= 100000 && visit[x*2] == 0) {
				queue.add(x*2);
				visit[x*2] = visit[x] + 1;
			}
		}
		System.out.println(visit[K]-1);
		
	}
}