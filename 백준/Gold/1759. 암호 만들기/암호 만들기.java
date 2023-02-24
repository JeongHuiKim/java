import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int L;
	static int C;
	static String[] alph;
	static boolean[] isSelected;
	static String[] ans;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		alph = in.readLine().split(" ");
		Arrays.sort(alph);
		isSelected = new boolean[C];
		ans = new String[L];
		
		permute(0, 0);
		
		System.out.print(sb);
	}

	static void permute(int cnt, int start) {

		// 기저조건
		if(cnt == L) {
			String output = "";
			int moCount = 0;
			for(int i = 0 ; i < L ; i++) {
				switch(ans[i]) {
				case "a":
				case "e":
				case "i":
				case "o":
				case "u":
					moCount++;
					break;
				}
				output += ans[i];
			}
			
			if(moCount >= 1 && L - moCount >= 2) {
				sb.append(output + "\n");	
			}
			return;
		}

		// 유도조건
		for(int i = start ; i < C ; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			ans[cnt] = alph[i];
			permute(cnt+1, i+1);
			isSelected[i] = false;
		}
	}
}