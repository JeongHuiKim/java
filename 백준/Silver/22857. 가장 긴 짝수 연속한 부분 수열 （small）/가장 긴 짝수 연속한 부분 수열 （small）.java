import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N  = Integer.parseInt(st.nextToken());
		int K  = Integer.parseInt(st.nextToken());

		int[] input = new int[N];
		int[] num = new int[N+1];
		
		int idx = 0;
		st = new StringTokenizer(in.readLine());
		for(int i = 0 ; i < N ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			if(input[i] % 2 != 0) {
				idx++;
			}
			else {
				num[idx]++;
			}
		}
		
//		System.out.println(idx);
//		System.out.println(Arrays.toString(num));
		
		int[] dp = new int[idx+1];
		
		if(idx <= K) {
			int sum = 0 ;
			for(int i = 0 ; i <= idx ; i++) {
				sum += num[i];
			}
			System.out.println(sum);
			System.exit(0);
		}
		
		for(int i = 0 ; i <= K ; i++) {
			dp[K] += num[i];
		}
		
		int max = dp[K];
		for(int i = K+1 ; i <= idx ; i++) {
			dp[i] = dp[i-1] + num[i] - num[i-K-1];
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
	}
}