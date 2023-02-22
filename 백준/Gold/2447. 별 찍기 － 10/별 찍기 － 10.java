import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static char[][] map;

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		map = new char[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = ' ';
			}
		}
		
		div(0,0,N);
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		
	}
	
	static void div(int r, int c, int size) {
		
		int half = size/3;
		
		if(size == 3) {
			for(int i = r; i < r + size ; i++) {
				for(int j = c ; j < c + size ; j++) {
					map[i][j] = '*';
				}
			}
			map[r+half][c+half] = ' ';
			return;
		}
		
		div(r,c,half);
		div(r,c+half,half);
		div(r,c+2*half,half);
		div(r+half,c,half);
		div(r+half,c+2*half,half);
		div(r+2*half,c,half);
		div(r+2*half,c+half,half);
		div(r+2*half,c+2*half,half);
	}
}