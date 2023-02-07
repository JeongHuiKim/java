import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] visit = new boolean[N];
		int[] contain = new int[M];
		dfs(visit,contain, N, M, 0);
	
	}
	
	static void dfs(boolean[] visit, int[] contain, int N , int M, int count) {
		
		if(count == M) {
			for(int con : contain) {
				System.out.print( (con+1) + " " );
			}
			System.out.println();
			return;
		}
		
		for(int i = 0 ; i < N ; i++) {
			if(!visit[i]) {
				visit[i] = true;
				contain[count] = i;
				dfs(visit, contain, N, M, count + 1);
				visit[i] = false;
			}
			
		}
		
		
	}
	
}
