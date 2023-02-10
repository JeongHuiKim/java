import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		// false는 상근이가 이긴거, true는 창영이가 이긴거
		boolean[] dp = new boolean[Math.max(4, N+1)];
		dp[2] = true;
		for(int i = 4 ; i <= N ; i++) {
			if( !dp[i-3] && !dp[i-1]) {
				dp[i] = !dp[i];
			}
		}
		
		System.out.println( dp[N] ? "CY" : "SK" );
		
	}
}