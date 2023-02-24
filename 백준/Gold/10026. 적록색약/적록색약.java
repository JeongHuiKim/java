import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static char[][] map;
	static boolean[][][] isSelected;
	static int N;

	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		map = new char[N][N];
		isSelected = new boolean[N][N][2];
		
		for(int i = 0 ; i < N ; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		int count_normal = 0;
		int count_RG = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(!isSelected[i][j][0]) {
					bfs(i,j,0);
					count_normal++;
				}
				if(!isSelected[i][j][1]) {
					bfs(i,j,1);
					count_RG++;
				}
			}
		}
		System.out.println(count_normal + " " + count_RG);
	}
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static void bfs(int startX, int startY, int con) {
		
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(startX, startY));
		isSelected[startX][startY][con] = true;
		
		while(!queue.isEmpty()) {
			
			Node curr = queue.poll();
			
			for(int i = 0 ; i < 4 ; i++) {
				int x = curr.x + dx[i];
				int y = curr.y + dy[i];
				
				if(x >= 0 && x < N && y >= 0 && y < N && !isSelected[x][y][con]) {
					switch(con) {
					case 0:
						if(map[curr.x][curr.y] == map[x][y]) {
							queue.add(new Node(x,y));
							isSelected[x][y][con] = true;
						}
						break;
					case 1:
						if( (map[curr.x][curr.y] == map[x][y]) || (map[curr.x][curr.y] == 'R' && map[x][y] == 'G') || (map[curr.x][curr.y] == 'G' && map[x][y] == 'R') ) {
							queue.add(new Node(x,y));
							isSelected[x][y][con] = true;
						}
						break;
					}
				}
			}
		}
	}
	
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}