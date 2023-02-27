import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int count;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		boolean[][] map = new boolean[100][100];
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());			
			for(int r = x ; r < x + 10 ; r++) {
				for(int c = y ; c < y + 10 ; c++) {
					map[r][c] = true;
				}
			}
		}
		
		for(int i = 0 ; i < 100 ; i ++) {
			for(int j = 0 ; j < 100 ; j++) {
				if(map[i][j]) {
					check(map, i, j);
				}
			}
		}
		
		System.out.println(count);
	}
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static void check(boolean[][] map , int i, int j) {
		
		for(int k = 0 ; k < 4 ; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			
			if(x >= 0 && x < 100 && y >=0 && y < 100 && map[x][y]) continue;
			count++;
		}
	}
}