import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int[] tall = new int[9];
	static boolean[] isSelected = new boolean[9];
	static int[] ans = new int[9];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for(int i = 0 ; i < 9 ; i++) {
			tall[i] = Integer.parseInt(in.readLine());
		}
		
		Find(0,0);
		
		Arrays.sort(ans);
		
		for(int i = 0 ; i < 9 ; i++) {
			if( ans[i] != -1) {
				sb.append(ans[i] + "\n");
			}
		}
		
		System.out.print(sb);
	}	
	
	private static void Find(int cnt, int sum) {
		
		if(cnt == 7) {
			if(sum == 100) {
				for(int i = 0 ; i < 9 ; i++) {
					if(isSelected[i]) {
						ans[i] = tall[i];
					}
					else {
						ans[i] = -1;
					}
				}
			}
			return;
		}
		
		for(int i = 0 ; i < 9 ; i++) {
			if(isSelected[i]) {
				continue;
			}
			isSelected[i] = true;
			Find(cnt+1, sum + tall[i]);
			isSelected[i] = false;
		}
		
		
	}
	
}