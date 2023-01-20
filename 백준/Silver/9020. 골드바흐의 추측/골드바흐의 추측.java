import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for(int test_case = 0 ; test_case < T ; test_case++) {
			int N = Integer.parseInt(in.readLine());
			
			int[] num = new int[N+1];
			num[1] = 1;
			
			//소수 구하기
			for(int i = 2 ; i <= Math.sqrt(N) ; i++) {
				if(num[i] == 0) {
					int no = i;
					while(true) {
						no += i;
						if(no > N) {
							break;
						}
						num[no] = 1;
					}
				}
			}
			
			//골드바흐 찾기
			int max = -1;
			for(int i = 2 ; i <= N/2 ; i++) {
				if(num[i] == 0 && num[N-i] == 0) {
					if(i > max) {
						max = i;
					}
				}
			}
			
			System.out.println(max + " " + (N-max));
			
		}
	}
}
