import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		long[] dp = new long[Math.max(2, N+1)];
		
		dp[0] = 0 ; 
		dp[1] = 1;
		
		for(int i = 2 ; i <= N ; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[N]);
		
		
	}
}