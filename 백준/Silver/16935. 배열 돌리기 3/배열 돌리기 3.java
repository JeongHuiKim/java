import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int N;
	static int M;

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(in.readLine());

		for(int i = 0 ; i < R ; i++) {
			int oper = Integer.parseInt(st.nextToken());
			switch(oper) {
			case 1:
				oper1();
				break;
			case 2:
				oper2();
				break;
			case 3:
				oper3();
				break;
			case 4:
				oper4();
				break;
			case 5:
				oper5();
				break;
			case 6:
				oper6();
				break;
			}
		}

		for(int i = 0 ; i < N ; i++) {
			for( int j = 0; j < M ; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.print(sb);

	}

	// 상하 반전 시키는 연산
	static void oper1() {

		// 가로로 이동하면서
		for(int i = 0 ; i < M ; i++) {
			// 상하를 바꿔줌
			for(int j = 0 ; j <= (N-1)/2 ; j++) {
				int temp = map[j][i];
				map[j][i] = map[N-1-j][i];
				map[N-1-j][i] = temp;
			}
		}
	}

	static void oper2() {
		// 세로로 이동하면서
		for(int i = 0 ; i < N ; i++) {
			// 상하를 바꿔줌
			for(int j = 0 ; j <= (M-1)/2 ; j++) {
				int temp = map[i][j];
				map[i][j] = map[i][M-1-j];
				map[i][M-1-j] = temp;
			}
		}
	}

	static void oper3() {
		// 오른쪽 90도 이동
		int[][] newmap = new int[M][N];

		for(int i = 0 ; i < N ; i++) {
			for(int j = 0; j < M ; j++) {
				newmap[j][N-1-i] = map[i][j];
			}
		}
		map = new int[M][N];
		map = newmap;
		int temp = N;
		N = M;
		M = temp;
	}

	static void oper4() {
		// 왼쪽 90도 이동
		int[][] newmap = new int[M][N];

		for(int i = 0 ; i < N ; i++) {
			for(int j = 0; j < M ; j++) {
				newmap[M-1-j][i] = map[i][j];
			}
		}
		map = new int[M][N];
		map = newmap;
		int temp = N;
		N = M;
		M = temp;
	}

	static void oper5() {

		int[][] temp = new int[N/2][M/2];

		for(int i = 0 ; i < N/2 ; i++) {
			for(int j = 0 ; j < M/2 ; j++) {
				temp[i][j] = map[i][j];
			}
		}

		// 4 -> 1
		for(int i = 0; i < N/2 ; i++) {
			for(int j = 0 ; j < M/2 ; j++) {
				map[i][j] = map[i+N/2][j];
			}
		}
		// 3 -> 4
		for(int i = 0; i < N/2 ; i++) {
			for(int j = 0 ; j < M/2 ; j++) {
				map[i+N/2][j] = map[i+N/2][j+M/2];
			}
		}

		// 2 -> 3
		for(int i = 0; i < N/2 ; i++) {
			for(int j = 0 ; j < M/2 ; j++) {
				map[i+N/2][j+M/2] = map[i][j+M/2];
			}
		}
		//temp -> 2
		for(int i = 0; i < N/2 ; i++) {
			for(int j = 0 ; j < M/2 ; j++) {
				map[i][j+M/2] = temp[i][j];
			}
		}

	}

	static void oper6() {

		int[][] temp = new int[N/2][M/2];

		for(int i = 0 ; i < N/2 ; i++) {
			for(int j = 0 ; j < M/2 ; j++) {
				temp[i][j] = map[i][j];
			}
		}

		// 2 -> 1
		for(int i = 0; i < N/2 ; i++) {
			for(int j = 0 ; j < M/2 ; j++) {
				map[i][j] = map[i][j+M/2];
			}
		}
		// 3 -> 2
		for(int i = 0; i < N/2 ; i++) {
			for(int j = 0 ; j < M/2 ; j++) {
				map[i][j+M/2] = map[i+N/2][j+M/2];
			}
		}

		// 4 -> 3
		for(int i = 0; i < N/2 ; i++) {
			for(int j = 0 ; j < M/2 ; j++) {
				map[i+N/2][j+M/2] = map[i+N/2][j];
			}
		}
		//temp -> 4
		for(int i = 0; i < N/2 ; i++) {
			for(int j = 0 ; j < M/2 ; j++) {
				map[i+N/2][j] = temp[i][j];
			}
		}


	}

	// 0, 0 -> N, 0
	// 0, 1 -> N-1, 0

	// 1, 0 -> N, 1
	// 1, 1 -> N-1, 1




}