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
		
		String[] split = in.readLine().split(" ");
		
		int M = Integer.parseInt(split[0]);
		int N = Integer.parseInt(split[1]);
		
		int[] num = new int[N+1];
		
		for(int i = 2; i <= Math.sqrt(N) ; i++ ) {
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
		
		num[1] = 1;
		for(int i = M ; i <= N ; i++) {
			if(num[i] == 0) {
				System.out.println(i);
			}
		}
		
		
	}
}
