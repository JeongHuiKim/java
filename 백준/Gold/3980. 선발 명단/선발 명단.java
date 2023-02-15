import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] player = new int[11][11];     // 선수들의 능력치
	static boolean[] isSelected = new boolean[11];     // 해당 자리가 선택되었는지를 나타냄
	static boolean[] isPlayerSelected = new boolean[11];
	static int[] ans = new int[11]; 	// 몇번째 자리를 어느 선수에게 할당했는지를 나타냄
	static int N;
	static int M;
	static int max;

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for(int test_case = 0 ; test_case < T ; test_case++) {
			
			// 선수 정보 가져오기
			for(int i = 0 ; i < 11 ; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j = 0 ; j < 11 ; j++) {
					player[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			
			max = Integer.MIN_VALUE;
			combi(0, 0);
			sb.append(max + "\n");
		}
		System.out.print(sb);
		
	}
	
	static void combi(int cnt, int sum) {
		
		if(cnt == 11) {
			max = Math.max(max, sum);
			return;
		}
		
		//자리 선택
		for(int i = 0 ; i < 11 ; i++) {
			// 자리가 선택되지 않았다면
			if(!isSelected[i] && player[cnt][i] != 0) {
				isSelected[i] = true;
				combi(cnt+1, sum + player[cnt][i]);
				isSelected[i] = false;
			}
		}
		
	}

}