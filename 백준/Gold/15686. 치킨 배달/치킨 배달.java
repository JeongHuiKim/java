import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static boolean[] isSelected;
	static Node[] chik;
	static int chikCount = 0;
	static int count;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		chik = new Node[13];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < N ; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a == 2) {
					chik[chikCount++] = new Node(i,j, 0);
					map[i][j] = 0;
				}
				else {
					map[i][j] = a;	
				}
			}
		}
		
		isSelected = new boolean[chikCount];
		
		combi(0,0);
		
		System.out.println(min);
	}
	
	static void combi(int cnt, int start) {
		
		if(cnt == M) {
			// 거리 계산 해줘야됨
			calDis();
			return;
		}
		
		for(int i = start ; i < chikCount ; i++) {
			isSelected[i] = true;
			combi(cnt+1, i + 1 );
			isSelected[i] = false;
		}
	}

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static void calDis() {
		
		count = 0;
		
		boolean[][] visited = new boolean[N][N];
		Queue<Node> queue = new ArrayDeque<>();
		for(int i = 0 ; i < chikCount ; i++) {
			if(isSelected[i]) {
				queue.add(new Node(chik[i].x, chik[i].y,0));
			}
		}
		
		while(!queue.isEmpty()) {
			
			Node curr = queue.poll();
			if(map[curr.x][curr.y] == 1) {
				count += curr.time;
			}
			
			for(int i = 0 ; i < 4 ; i++) {
				int x = curr.x + dx[i];
				int y = curr.y + dy[i];
				
				if(x >= 0 && x < N && y >= 0 && y < N && !visited[x][y]) {
					queue.add(new Node(x,y, curr.time + 1));
					visited[x][y] = true;
				}
			}
		}
		
		min = Math.min(min, count);
	}
	
	static class Node{
		int x;
		int y;
		int time;
		Node(int x, int y, int time){
			this.x = x;
			this.y = y;
			this.time = time;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", time=" + time + "]";
		}
	}
	
}