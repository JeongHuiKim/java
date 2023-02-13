import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		int[] dp = new int[Math.max(N+1,3)];
		
		dp[1] = 1;
		dp[2] = 3;
		
		for(int i = 3 ; i <= N ; i++) {
			dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
		}
		
		System.out.println(dp[N]);
		
	}
}