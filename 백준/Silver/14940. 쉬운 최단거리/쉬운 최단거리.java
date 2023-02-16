import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
				
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		
		int x = 0;
		int y = 0;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					x = i;
					y = j;
				}
			}
		}
		
		
		bfs(map, visited, N, M, x,y);
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(visited[i][j]) {
					sb.append(map[i][j] + " ");
				}
				else {
					if(map[i][j] == 0) {
						sb.append("0 ");
					}
					else {
						sb.append("-1 ");
					}
				}
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void bfs(int[][] map, boolean[][] visited, int N, int M, int start_x, int start_y) {
		
		ArrayDeque<Node> queue = new ArrayDeque<>();
		visited[start_x][start_y] = true;
		queue.add(new Node(start_x, start_y, 0));
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			map[curr.x][curr.y] = curr.depth;
			
			for(int i = 0 ; i < 4 ; i++) {
				int x = curr.x + dx[i];
				int y = curr.y + dy[i];
				if(x>= 0 && x < N && y >= 0 && y < M && !visited[x][y]) {
					visited[x][y] = true;
					if(map[x][y] != 0) {
						queue.add(new Node(x,y,curr.depth+1));
					}
				}
			}
		}
	}
	
	static class Node{
		int x;
		int y;
		int depth;
		
		Node(int x, int y, int depth){
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
}