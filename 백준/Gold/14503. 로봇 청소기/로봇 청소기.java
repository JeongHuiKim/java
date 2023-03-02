import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int N;
	static int M;
	static int dir;
	static int count;

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		st = new StringTokenizer(in.readLine());
		int startX = Integer.parseInt(st.nextToken());
		int startY = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 청소를 한 경우 -1로 표시
		map[startX][startY] = -1;
		count++;
		clean(startX, startY);
		
		System.out.println(count);
	}
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static void clean(int startX, int startY) {
		
		int x = 0;
		int y = 0;
		int checkDir = 0;
		
		for(int i = 1 ; i < 4 ; i++) {
			checkDir = (dir - i) < 0 ? dir - i + 4 : dir -i;
			x = startX + dx[checkDir];
			y = startY + dy[checkDir];
			
			if(x >= 0 && x < N && y >= 0 && y < M && map[x][y] == 0) {
				map[x][y] = -1;
				count++;
				dir = checkDir;
				clean(x,y);
				return;
			}
		}
		
		x = startX + dx[dir];
		y = startY + dy[dir];
		
		if(x >= 0 && x < N && y >= 0 && y < M && map[x][y] == 0) {
			map[x][y] = -1;
			count++;
			clean(x,y);
			return;
		}
		
		checkDir = (dir - 2) < 0 ? dir + 2 : dir - 2;
		x = startX + dx[checkDir];
		y = startY + dy[checkDir];
		
		if(x >= 0 && x < N && y >= 0 && y < M && map[x][y] != 1) {
			clean(x,y);
		}
		else {
			return;
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