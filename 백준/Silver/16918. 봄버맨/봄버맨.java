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
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N  = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		
		for(int i = 0 ; i < R ; i++) {
			char[] input =  in.readLine().toCharArray();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = input[j] == 'O' ? 2 : 0;
			}
		}
		
		for(int k = 1 ; k < N ; k++) {
			boolean[][] isBoomed = new boolean[R][C];
			for(int i = 0 ; i < R ; i++) {
				for(int j = 0 ; j < C ; j++) {
					
					if(isBoomed[i][j]) continue;
					
					//0인 경우 폭탄 설치해줘야함
					if(map[i][j] == 0) {
						map[i][j] = 3;
					}
					//1보다 큰 경우 폭탄 시간 1 줄어듬
					else if(map[i][j] > 1) {
						map[i][j]--;
					}
					// 1인 경우 폭탄이 터짐~ boom~
					else {
						map[i][j] = 0;
						for(int h = 0 ; h < 4 ; h++) {
							int x = i + dx[h];
							int y = j + dy[h];
							if(x >= 0 && x < R && y >= 0 && y < C) {
								if(map[x][y] == 1) continue;
								isBoomed[x][y] = true;
								map[x][y] = 0;
							}
						}
					}
				}
			}
		}
		
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				sb.append(map[i][j] == 0 ? "." : "O");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}