import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		int[] cost = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			cost[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(cost);
		
		int total = 0;

		int count = 0;
		
//		System.out.println(Arrays.toString(cost));
		
		int idx = N-1;
		while(true) {
			
			if(idx < 2) {
				break;
			}
			count += cost[idx--] + cost[idx--];
			idx--;
//			System.out.println(idx);
		}
		
		for(int i = idx ; i >= 0 ; i--) {
			count += cost[i];
		}
		System.out.println(count);
	}
}