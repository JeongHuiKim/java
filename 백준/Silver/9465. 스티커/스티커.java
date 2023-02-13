import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int test_case = 0 ; test_case < T ; test_case++) {
			
			int N = Integer.parseInt(in.readLine());
			
			int[][] num = new int[2][N];
			
			int total = 0;
			
			for(int i = 0 ; i < 2 ; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j = 0 ; j < N ; j++) {
					num[i][j] = Integer.parseInt(st.nextToken());
					total += num[i][j];
				}
			}
			
			// 0 : num[0] 포함, 1 : num[1] 포함, 2 : 포함 안함
			int[][] dp = new int[3][N];
			
			dp[0][0] = num[0][0];
			dp[1][0] = num[1][0];
			dp[2][0] = 0;
			
			for(int i = 1 ; i < N ; i++) {
				dp[0][i] = Math.max(dp[1][i-1] + num[0][i], dp[2][i-1] + num[0][i]);
				dp[1][i] = Math.max(dp[0][i-1] + num[1][i], dp[2][i-1] + num[1][i]);
				dp[2][i] = Math.max(dp[0][i-1], dp[1][i-1]);
			}
			
			System.out.println(Math.max(Math.max(dp[0][N-1], dp[1][N-1]), dp[2][N-1]));
			
		}
	}
}