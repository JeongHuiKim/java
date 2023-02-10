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
//		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		long[] num = new long[N];
		
		for(int i = 0 ; i < N ; i++) {
			num[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(num);
		
		long total = 0;
		
		for(int i = 0 ; i < N ; i++) {
			long cost = num[i] - i ;
			if(cost >= 0) {
				total += cost;
			}
		}
		
		long total2 = 0;
		for(int i = 0 ; i < N ; i++) {
			long cost = num[N-1-i] - i ;
			if(cost >= 0) {
				total2 += cost;
			}
		}

		System.out.println(Math.max(total, total2));
	}
}