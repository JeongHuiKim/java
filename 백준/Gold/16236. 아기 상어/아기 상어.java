import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static Shark shark;
	static int[][] map;
	static int N;
	static int time;
	
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
				}
			}
		}
		
		while(true) {
			bfs();
		}
	}
	
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	
	static void bfs() {
		
		boolean[][] isSelected = new boolean[N][N];
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(shark.x, shark.y, 0));
		isSelected[shark.x][shark.y] = true;
		
		PriorityQueue<Node> answer = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.x == o2.x) {
					return o1.y - o2.y;
				}
				return o1.x - o2.x;
			}
		});
		
		int currentTime = -1;
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			
			for(int i = 0 ; i < 4 ; i++) {
				int x = curr.x + dx[i];
				int y = curr.y + dy[i];
				
				// 범위를 만족하는지 확인 
				if(x >= 0 && x < N && y >=0 && y < N && !isSelected[x][y] && map[x][y] <= shark.size) {
					if(map[x][y] < shark.size && map[x][y] != 0 ) {
						if(answer.size() == 0 ) {
							answer.add(new Node(x, y, curr.time+1));
							isSelected[x][y] = true;
							currentTime = curr.time;
						}
						else if( currentTime == curr.time ) {
							answer.add(new Node(x, y, curr.time+1));
							isSelected[x][y] = true;
						}
						else {
							break;
						}
					}
					else{
						queue.add(new Node(x,y,curr.time+1));
						isSelected[x][y] = true;
					}
				}
			}
		}
		
		if(answer.size()!=0) {
			Node next = answer.poll();
			map[shark.x][shark.y] = 0;
			map[next.x][next.y] = 9;
			shark.x = next.x;
			shark.y = next.y;
			shark.eat++;
			if(shark.eat == shark.size) {
				shark.eat = 0;
				shark.size++;
			}
			time += (currentTime + 1);
			return;
		}
		
		System.out.println(time);
		System.exit(0);
	}
	
	//해당 노드로 이동하는데 걸리는 시간
	static class Node{
		int x;
		int y;
		int time;
		Node(int x, int y, int time){
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	// 상어 정보, 최초의 크기는 2
	static class Shark{
		int x;
		int y;
		int size = 2;
		int eat = 0;
		Shark(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}