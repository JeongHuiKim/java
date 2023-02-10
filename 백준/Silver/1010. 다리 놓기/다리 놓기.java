import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int test_case = 0 ; test_case < T ; test_case++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] dp = new int[M+1][N+1];
			
			for(int i = 0 ; i <= M ; i++) {
				for(int j = 0 ; j <= Math.min(i, N) ; j++) {
					if(j == 0 || i == j) {
						dp[i][j] = 1;
						continue;
					}
					
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}
			}
			
			sb.append(dp[M][N] + "\n");
			
		}
		
		System.out.print(sb);
		
	}
}