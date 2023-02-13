import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] num = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 0 ; i < N ; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

//		System.out.println(Arrays.toString(num));
		
		long[] dp = new long[N];
		
		long max = Integer.MIN_VALUE;
		for(int i = 0 ; i < N ; i++) {
			dp[i] = num[i];
			for(int j = 0 ; j < i ; j++) {
				if(num[j] < num[i]) {
					dp[i] = Math.max(dp[j] + num[i], dp[i]);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
//		System.out.println(Arrays.toString(dp));
		
		System.out.println(max);
	}
}