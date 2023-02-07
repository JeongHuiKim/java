import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int num[];
	static boolean visit[];
	static int ans[];
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ans = new int[M];
		num = new int[N];
		for(int i = 0 ; i < N ; i++) {
			num[i] = i+1;
		}
		visit = new boolean[N];
		
		permute(0);
		
		System.out.println(sb);
		
	}
	
	static void permute(int cnt) {
		
		// 기저 조건
		if(cnt == M) {
			for(int i = 0 ; i < M ; i++) {
				sb.append(ans[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0 ; i < N ; i++) {
			
			if(visit[i]) continue;
			
			ans[cnt] = num[i];
			visit[i] = true;
			permute(cnt+1);
			visit[i] = false;
			
		}
		
		
	}
	
}