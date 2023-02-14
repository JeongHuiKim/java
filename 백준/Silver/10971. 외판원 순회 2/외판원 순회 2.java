import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static boolean[] isSelected;
	static int[] ans;
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		isSelected = new boolean[N];
		ans = new int[N];
		
		combi(0);
		
		System.out.println(min);
	}
	
	static void combi(int cnt) {
		
		if(cnt == N) {
			int sum = 0;
			for(int i = 0 ; i < N-1 ; i++) {
				if(map[ans[i]][ans[i+1]] == 0) {
					return;
				}
				sum += map[ans[i]][ans[i+1]];
			}
			if(map[ans[N-1]][ans[0]] == 0) {
				return;
			}
			sum += map[ans[N-1]][ans[0]];
			min = Math.min(sum, min);
//			System.out.println(Arrays.toString(ans));
			return;
		}
		
		for(int i = 0 ; i < N ; i++) {
			if(!isSelected[i]) {
				
				ans[cnt] = i;
				isSelected[i] = true;
				combi(cnt+1);
				isSelected[i] = false;
				
			}
		}
		
	}

}