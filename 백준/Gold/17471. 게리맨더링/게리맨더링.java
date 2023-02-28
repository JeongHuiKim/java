import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] population;
	static ArrayList<Integer>[] graph;
	static boolean[] isSelected;
	static int total_count;
	static int total_population = 0;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());
		
		isSelected = new boolean[N+1];
		population = new int[N+1];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 1 ; i <= N ; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			total_population += population[i];
		}
		
		graph = new ArrayList[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			graph[i] = new ArrayList<Integer>();
			st = new StringTokenizer(in.readLine());
			int count = Integer.parseInt(st.nextToken());
			for(int j = 0 ; j < count ; j++) {
				graph[i].add(Integer.parseInt(st.nextToken()));
			}
		}		
		
		subset(1,0);
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static void subset(int cnt, int count) {
		
		if(cnt == N+1) {
			if(count == 0 || count == N) return;
			//true와  false 모두에 대해 하나의 정점에서 모두 탐색이 가능한지 확인해야됨\
			int cal = 0;
			if(N == bfs(true) + bfs(false)) {
				for(int i = 1 ; i <= N ; i++) {
					if(isSelected[i]) {
						cal += population[i];
					}
				}
				min = Math.min(min, Math.abs(total_population - 2*cal));
			}
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt+1,count+1);
		isSelected[cnt] = false;
		subset(cnt+1,count);
		
	}
	
	static int bfs(boolean mode) {
		// mode : true -> 그냥 진행
		// mode : false -> true <-> false 변경
		
		int startIdx = 0;
		for(int i = 1 ; i <= N ; i++) {
			if(isSelected[i] == mode) {
				startIdx = i;
				break;
			}
		}
		
		boolean[] isChecked = new boolean[N+1];
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(startIdx);
		isChecked[startIdx] = true;
		int count = 1;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for(int i = 0 ; i < graph[curr].size() ; i++) {
				int Idx = graph[curr].get(i);
				if(!isChecked[Idx] && isSelected[Idx] == mode) {
					queue.add(Idx);
					isChecked[Idx] = true;
					count++;
				}
			}
		}
		
		return count;
	}

}