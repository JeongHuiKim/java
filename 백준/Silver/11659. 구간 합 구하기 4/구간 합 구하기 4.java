import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N+1];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 1 ; i <= N ; i++) {
			num[i] = Integer.parseInt(st.nextToken()) + num[i-1];
		}
		
		for(int i = 0 ; i < T ; i++) {
			st = new StringTokenizer(in.readLine());			
			sb.append(- num[Integer.parseInt(st.nextToken())-1] + num[Integer.parseInt(st.nextToken())]).append("\n");
		}
		
		System.out.print(sb);
		
	}
}