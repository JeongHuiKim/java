import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		int[] dp = new int[N+1];
		
		dp[1] = 1;
		
		for(int i = 2 ; i <= N ; i++) {
			if( Math.pow(((int) Math.sqrt(i)), 2) == i) {
				dp[i] = 1;
			}
			else {
				int Min = Integer.MAX_VALUE;
				for(int j = 1 ; j <= Math.sqrt(i) ; j++) {
					Min = Math.min(Min, dp[j*j] + dp[i-j*j] );
				}
				dp[i] = Min;
			}
		}		
		
		System.out.println(dp[N]);
//		System.out.println(Math.pow(((int) Math.sqrt(11339)), 2) == 11339);
	}
}