import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[][] map = new int[100][100];
		
		int count = 0;
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int dx = Integer.parseInt(st.nextToken());
			int dy = Integer.parseInt(st.nextToken());
			for(int x = 0; x < 10; x++) {
				for(int y = 0 ; y < 10 ; y ++) {
					if(map[dx+x][dy+y] == 0) {
						map[dx+x][dy+y] = 1;
						count++;
					}
					
				}
			}
		}
		
		System.out.println(count);
		
		
	}
}
