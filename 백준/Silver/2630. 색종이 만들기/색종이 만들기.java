import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int white;
	static int blue;

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		div(0,0,N);
		
		System.out.println(white);
		System.out.println(blue);
	}
	
	static void div(int r, int c, int size) {
		
		int half = size/2;
		
		int sum = 0;
		for(int i = r ; i < r + size ; i++) {
			for(int j = c ; j < c + size ; j++) {
				sum += map[i][j];
			}
		}
		
		if(sum == 0) {
			white++;
			return;
		}
		else if(sum == size*size) {
			blue++;
			return;
		}
		
		div(r,c,half);
		div(r+half,c,half);
		div(r,c+half,half);
		div(r+half,c+half,half);
		
	}
}