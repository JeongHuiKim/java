import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;


public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Integer> bridge = new HashMap<>();
		HashMap<Integer, Integer> snake = new HashMap<>();
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			bridge.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(in.readLine());
			snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int[] visit = new int[101];
		
		
		//dfs
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visit[1] = 1;
		int value = 0;
		queue.add(value);
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			value = queue.poll();
			if(x == 100) {
				break;
			}
			for(int i = 1; i <= 6 ; i++) {
				int goX = x + i;
				if(goX <101 && visit[goX] == 0) {
					if(snake.containsKey(goX)) {
						goX = snake.get(goX);
					}
					else if(bridge.containsKey(goX)) {
						goX = bridge.get(goX);
					}
					visit[goX] = 1;
					queue.add(goX);
					queue.add(value+1);
				}
			}	
		}
		
		System.out.println(value);
	}
}
