import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map1 = new int[N][M];
		int[][] map2 = new int[N][M];
		
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M ; j++) {
				map1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M ; j++) {
				map2[i][j] = Integer.parseInt(st.nextToken()) + map1[i][j];
			}
		}
		
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < M ; j++) {
				System.out.print(map2[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
