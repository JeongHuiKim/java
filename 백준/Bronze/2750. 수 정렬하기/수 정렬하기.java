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
		
		int N = Integer.parseInt(in.readLine());
		
		int[] num = new int[N];
		
		for(int i = 0; i < N ; i++) {
			num[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(num);

		for(int i = 0; i < N ; i++) {
			System.out.println(num[i]);
		}
		
	}
}
