import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] ans;

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

		ans = new int[N+1];

		for(int i = 0 ; i <= N ; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for(int i = 1 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			graph.get(num1).add(num2);
			graph.get(num2).add(num1);
		}

//		for(int i = 1 ; i <= N ; i++) {
//			System.out.println(graph.get(i));
//		}

		bfs(graph);

		for(int i = 2 ; i < N+1 ; i++) {
			sb.append(ans[i]).append("\n");
		}

		System.out.print(sb);
	}

	private static void bfs(ArrayList<ArrayList<Integer>> graph) {

		Queue<Integer> queue = new LinkedList<>();
		ans[1] = -1;
		queue.add(1);

		while(!queue.isEmpty()) {
			int num = queue.poll();

			for(int i = 0 ; i < graph.get(num).size() ; i++) {
				int x = graph.get(num).get(i);
				if(ans[x] == 0) {
					ans[x] = num;
					queue.add(x);
				}	
			}
		}
	}
}