import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static char[][] map;

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		map = new char[N][2*N-1];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < 2*N-1 ; j++) {
				map[i][j] = ' ';
			}
		}
		
		div(N-1,0,N);
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < 2*N-1 ; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		
	}
	
	static void div(int r, int c, int size) {
		
		int half = size/2;
		
		if(size == 3) {
			map[r-2][c+2] = '*';
			map[r-1][c+1] = '*';
			map[r-1][c+3] = '*';
			for(int i = c ; i < c + 5 ; i++) {
				map[r][i] = '*';
			}
			return;
		}
		
		div(r,c,half);
		div(r,c+size,half);
		div(r-half,c+half,half);
	}
}