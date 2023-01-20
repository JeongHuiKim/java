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
		
		while(true) {
			
			int n = Integer.parseInt(in.readLine());
			if(n == 0) {
				break;
			}
			
			int[] num = new int[2*n+1];
			num[1] = 1;
			
			for(int i = 2 ; i <= Math.sqrt(2*n) ; i++) {
				if(num[i] == 0) {
					int no = i;
					while(true) {
						no += i;
						if(no > 2*n) {
							break;
						}
						num[no] = 1;
					}
				}
			}
			
			int count = 0;
			for(int i = n+1 ; i <= 2*n ; i++) {
				if(num[i] == 0) count++;
			}
			
			System.out.println(count);
			
		}
		
		
	}
}
