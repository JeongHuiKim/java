import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[][] map = new int[N][N];
		long[][] dp = new long[N][N];
		
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][map[0][0]] = 1;
		dp[map[0][0]][0] = 1;
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(i == N-1 && j == N-1) {
					break;
				}
				
				if(dp[i][j] != 0) {
					int len = map[i][j];
					//오른쪽으로 가는 경우
					if(len+j < N) {
						dp[i][len+j] += dp[i][j];
//						if(dp[i][len+j] == 0) {
//							dp[i][len+j] = dp[i][j]+1;
//						}
//						else {
//							dp[i][len+j] = Math.min(dp[i][len+j], dp[i][j]+1);
//						}
					}
					
					//아래쪽으로 가는 경우
					if(len+i < N) {
						dp[len+i][j] += dp[i][j];
//						if(dp[len+i][j] == 0) {
//							dp[len+i][j] = dp[i][j]+1;
//						}
//						else {
//							dp[len+i][j] = Math.min(dp[len+i][j], dp[i][j]+1);
//						}
					}
				}
			}
		}
		
		System.out.println(dp[N-1][N-1]);
		
	}
}