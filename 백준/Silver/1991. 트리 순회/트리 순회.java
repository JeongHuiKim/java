import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class Main {

	static HashMap<String, ArrayList<String>> graph;
	static HashSet<String> set;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		graph = new HashMap<>();

		for(int i = 0 ; i < N ; i++) {
			String[] split = in.readLine().split(" ");
			graph.put(split[0], new ArrayList<String>());
			graph.get(split[0]).add(split[1]);
			graph.get(split[0]).add(split[2]);
		}

		//		for(Entry<String, ArrayList<String>> a : graph.entrySet()) {
		//			System.out.println(a.getKey() + " " + a.getValue().toString());
		//		}

		set = new HashSet<>();

		prefix("A");
		sb.append("\n");

		infix("A");
		sb.append("\n");

		postfix("A");
		sb.append("\n");

		System.out.print(sb);
	}

	private static void prefix(String start) {

		sb.append(start);

		for( String child : graph.get(start)) {
			if(!child.equals(".")) {
				prefix(child);
			}
		}
	}
	
	private static void infix(String start) {

		int count = 0;
		for( String child : graph.get(start)) {
			count++;
			if(!child.equals(".")) {
				infix(child);
			}
			if(count == 1) {
				sb.append(start);
			}
			
		}
	}

	private static void postfix(String start) {

		for( String child : graph.get(start)) {
			if(!child.equals(".")) {
				postfix(child);
			}
		}
		sb.append(start);
	}


}