import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static boolean[] isSelected;
	static int[] input;
	static int[] ans;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isSelected = new boolean[N];
		ans = new int[M];
		input = new int[N];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0 ; i < N ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);

		combi(0);
		
		System.out.print(sb);
	}
	
	static void combi(int cnt) {
		if(cnt == M) {
			for(int i = 0 ; i < M ; i++) {
				sb.append(ans[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0 ; i < N ; i++) {
			if(!isSelected[i]) {
				ans[cnt] = input[i];
				isSelected[i] = true;
				combi(cnt+1);
				isSelected[i] = false;
			}
		}
		
	}
}