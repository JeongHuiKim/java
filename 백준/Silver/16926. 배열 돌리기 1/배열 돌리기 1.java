import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int cnt = 0;
		while(true) {
			if(cnt == Math.min(N, M) / 2) break;
			
			for(int k = 0 ; k < R ; k++) {
				int x = 0+cnt;
				int y = 0+cnt;
				int change = map[x][y];
				for(int i = 0 ; i < 4 ; i++) {
					while(true) {
						if( x+dx[i] >= 0+cnt && x+dx[i] < N-cnt && y+dy[i] >=0+cnt && y+dy[i] < M-cnt) {
							int temp = map[x+dx[i]][y+dy[i]];
							map[x+dx[i]][y+dy[i]] = change;
							change = temp;
							x = x+dx[i];
							y = y+dy[i];
						}
						else {
							break;
						}
					}
				}	
			}
			
			cnt++;
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}