import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map;
	static Shark shark;
	static int totalTime = 0;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark = new Shark(i,j);
					map[i][j] = 0;
				}
			}
		}
		
		while(true) {
			hunt();
		}
		
	}
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static void hunt() {
		
		boolean[][] visited = new boolean[N][N];
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(shark.x, shark.y, 0));
		visited[shark.x][shark.y] = true;
		
		PriorityQueue<Node> temp = new PriorityQueue<>();
		
		int time = 0 ;
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			
			if( map[curr.x][curr.y] != 0 && map[curr.x][curr.y] < shark.size) {
				if(temp.size() == 0) {
					time = curr.time;
				}
				else if(time != curr.time) {
					break;
				}
				temp.add(curr);
			}
			
			for(int i = 0 ; i < 4 ; i++) {
				int x = curr.x + dx[i];
				int y = curr.y + dy[i];
				
				if(x >= 0 && x < N && y >= 0 && y < N && map[x][y] <= shark.size && !visited[x][y]) {
					queue.add(new Node(x,y,curr.time+1));
					visited[x][y] = true;
				}
			}
		}
		
		if(temp.size() == 0) {
			System.out.println(totalTime);
			System.exit(0);
		}
		else {
			Node eat = temp.poll();
			map[eat.x][eat.y] = 0;
			shark.x = eat.x;
			shark.y = eat.y;
			shark.eatCount++;
			totalTime += eat.time;
			if(shark.eatCount == shark.size) {
				shark.size++;
				shark.eatCount =0;
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int time = 0;
		Node(int x, int y, int time){
			this.x = x;
			this.y = y;
			this.time = time;
		}
		
		@Override
		public int compareTo(Node o) {
			if(this.x == o.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}
	}
	
	static class Shark{
		int x;
		int y;
		int size = 2;
		int eatCount = 0;
		Shark(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}