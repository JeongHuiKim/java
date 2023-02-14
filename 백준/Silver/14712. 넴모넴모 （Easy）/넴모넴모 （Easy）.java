import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static boolean[][] isSelected;
	static int count = 0;

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		// 행(가로) 갯수
		N =  Integer.parseInt(st.nextToken());
		// 열(세로) 갯수
		M =  Integer.parseInt(st.nextToken());

		isSelected = new boolean[N][M];

		combi(0,0);

		System.out.println(count);
	}

	static void combi(int row, int col) {

		// 기저 조건
		if(row == N-1 && col == M) {
			
			
			
			
			for(int i = 0; i < N-1 ; i++) {
				for(int j = 0; j < M-1 ; j++) {
					int nemCount = 0;
					for(int a = 0 ; a < 2 ; a++) {
						for(int b = 0 ; b < 2 ; b++) {
							if(!isSelected[i+a][j+b]) {
								nemCount++;
							}
						}
					}
					if(nemCount == 0) {
						return;
					}
				}
			}
			count++;
			return;
		}
		
		if(col == M) {
			row++;
			col = 0;
		}

		isSelected[row][col] = true;
		combi(row, col+1);
		isSelected[row][col] = false;
		combi(row, col+1);

	}

}