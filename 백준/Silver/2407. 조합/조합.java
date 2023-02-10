import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		BigInteger[][] dp = new BigInteger[N+1][M+1];
		
		for(int i = 0 ; i <= N ; i++) {
			for(int j = 0 ; j <= Math.min(M, i) ; j++) {
				if(j == 0 || j == i) {
					dp[i][j] = BigInteger.valueOf(1);
					continue;
				}
				dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
			}
		}
		
		System.out.println(dp[N][M]);
		
	}
}