import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		String[] input = in.readLine().split(" ");
		boolean[] check = new boolean[input.length];
		
		TreeMap<Integer, ArrayList<String>> map = new TreeMap<>();
		for(int i = 1 ; i <= N ; i++) {
			map.put(i, new ArrayList<String>() );
		}
		
		for(int i = 0 ; i < N ; i++) {
			boolean isCounted = false;
			for(int j = 0 ; j < input.length ; j++) {
				if(!check[j]) {
					if(!isCounted) {
						map.get(N-i).add(input[j]);
						check[j] = true;
					}
					isCounted = !isCounted;
				}
			}
		}
		
		for(Entry<Integer, ArrayList<String>> a : map.entrySet()) {		
			for(String output : a.getValue()) {
				sb.append(output + " ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}