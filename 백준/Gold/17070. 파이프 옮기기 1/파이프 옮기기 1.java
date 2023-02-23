import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static int count;
	
	// 가로 : 0, 세로 : 1, 대각선 : 2
	static int[][] dx = new int[][] { {0}, {1}, {0,1,1}};
	static int[][] dy = new int[][] { {1}, {0}, {1,0,1}};
	
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());
		
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		map[0][0] = map[0][1] = 2;
		
		move(0,1,0);
		System.out.println(count);
		
	}
	
	static void move(int startX, int startY, int dir) {
		
//		if(count == 2) {
//			for(int i = 0 ; i < N ; i++) {
//				for(int j = 0 ; j < N ; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
//			System.exit(0);
//		}
		
		if(startX == N -1 && startY == N-1) {
			count++;
			return;
		}
		
		for(int i = 0 ; i < 3 ; i++) {
			if(dir == 0 && i == 1) continue;
			if(dir == 1 && i == 0) continue;
			
			int check = 0;
			for(int j = 0 ; j < dx[i].length ; j++) {
				int x = startX + dx[i][j];
				int y = startY + dy[i][j];
				if(x >= 0 && x < N && y >= 0 && y < N && map[x][y] == 0) {
					check++;
				}
			}
			
			if(check == dx[i].length) {
				// map을 2로
				int x = 0;
				int y = 0;
				for(int j = 0 ; j < dx[i].length ; j++) {
					x = startX + dx[i][j];
					y = startY + dy[i][j];
					map[x][y] = 2;
				}
				//다음으로 이동
				move(x,y,i);
				// map을 0으로
				for(int j = 0 ; j < dx[i].length ; j++) {
					x = startX + dx[i][j];
					y = startY + dy[i][j];
					map[x][y] = 0;
				}
			}
		}
		
		
	}
}