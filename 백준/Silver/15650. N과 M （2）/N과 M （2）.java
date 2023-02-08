import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N ;
	static int M;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[M];
		
		combi(0,1);
		
		System.out.print(sb);
	}
	
	private static void combi(int cnt, int start) {
	
		if(cnt == M) {
			for(int i = 0 ; i < M ; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start ; i <= N ; i++ ) {
			
			numbers[cnt] = i;
			combi(cnt+1, i+1);
		}	
	}
}