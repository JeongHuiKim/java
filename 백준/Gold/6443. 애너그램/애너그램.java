import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static char[] input;
	static boolean[] isSelected;
	static char[] ans;
	static int[] check;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for(int test_case = 0 ; test_case < T ; test_case++) {
			input = in.readLine().toCharArray();
			Arrays.sort(input);

			isSelected = new boolean[input.length];
			ans = new char[input.length];
			check = new int[input.length];

			combi(0);
		}

		System.out.print(sb);

	}

	static void combi(int cnt) {

		if(cnt == input.length) {
			String a = "";
			for(int i = 0 ; i < input.length ; i++) {
				a += ans[i];
			}
			sb.append(a+"\n");

			return;
		}

		check[cnt] = 0;
		for(int i = 0 ; i < input.length ; i++) {
			if(!isSelected[i] && check[cnt] < (input[i] - 'a' + 1) ) {
				check[cnt] = input[i] - 'a' + 1;
				ans[cnt] = input[i];
				isSelected[i] = true;
				combi(cnt+1);
				isSelected[i] = false;
			}
		}
	}

}