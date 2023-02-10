import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		int[] distance = new int[N-1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0 ; i < N-1 ; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] cost = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i = 0 ; i < N ; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		int totalCost = 0;
		
		int minFuel = Integer.MAX_VALUE;
		for(int i = 0 ; i < N-1 ; i++) {
			minFuel = Math.min(minFuel, cost[i]);
			totalCost += minFuel * distance[i];
		}
		
		System.out.println(totalCost);
		
		
	}
}