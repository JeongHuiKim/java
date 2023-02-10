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
		
		float[] num = new float[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 0 ; i < N ; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		for(int i = 0 ; i < N-1 ; i++) {
			num[N-1] += num[i]/2;
		}
		
		if( ((float) ((int) num[N-1])) == num[N-1]) {
			System.out.println( (int) num[N-1] );
		}
		else {
			System.out.println(num[N-1]);
		}
	}
}