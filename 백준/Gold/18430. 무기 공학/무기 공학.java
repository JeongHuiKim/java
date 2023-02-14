import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static boolean[][] isSelected;
	static int N;
	static int M;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// 세로
		N = Integer.parseInt(st.nextToken());
		// 가로
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		isSelected = new boolean[N][M];
		
		for(int i = 0 ; i< N ; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combi(0,0,0);
		
		System.out.println(max);
		
	}
	
	static int[] dx = {1,1,-1,-1};
	static int[] dy = {1,-1,1,-1};
	
	static void combi(int row, int col, int sum) {
		
		if(col == M) {
			row++;
			col = 0;
		}

		for(int i = row ; i < N ; i++) {
			for(int j = col ; j < M ; j++) {
				
				if(isSelected[i][j]) continue;
				
				for(int k = 0 ; k < 4 ; k++) {
					int x = i + dx[k];
					int y = j + dy[k];
					// 인덱스 범위 만족하면서
					if(x >= 0 && x < N && y >= 0 && y < M) {
						// 선택되지 않은 구역이면
						if(!isSelected[x][j] && !isSelected[i][y]) {
							isSelected[x][j] = true;
							isSelected[i][y] = true;
							isSelected[i][j] = true;
							combi(row, col+1, sum + map[x][j] + map[i][y] + map[i][j]*2);
							isSelected[x][j] = false;
							isSelected[i][y] = false;
							isSelected[i][j] = false;	
						}
					}
				}
			}
		}
		
		max = Math.max(sum, max);
		
	}

}