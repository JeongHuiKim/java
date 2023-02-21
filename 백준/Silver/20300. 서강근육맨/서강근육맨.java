import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static Queue<String> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		BigInteger[] nums = new BigInteger[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0 ; i < N ; i++) {
			nums[i] = new BigInteger(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		if(N % 2 == 0) {
			BigInteger max = BigInteger.ZERO;
			int start = 0;
			int end = N-1;
			while(start < end) {
				BigInteger cal = nums[start++].add(nums[end--]);
				if(max.compareTo(cal) < 0) {
					max = cal;
				}
			}
			System.out.println(max);
		}
		else {
			BigInteger max = nums[N-1];
			int start = 0;
			int end = N-2;
			while(start < end) {
				BigInteger cal = nums[start++].add(nums[end--]);
				if(max.compareTo(cal) < 0) {
					max = cal;
				}
			}
			System.out.println(max);
		}
	}
}