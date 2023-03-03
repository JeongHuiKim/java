import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int T;
	static int[][] map;
	static int[][] temp;
	static Node[] machine = new Node[2];

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[N][M];


		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					if(machine[0] == null) {
						machine[0] = new Node(i,j);
					}
					else {
						machine[1] = new Node(i,j);
					}
				}
			}
		}

		for(int i = 0 ; i < T ; i++) {
			// 번식 진행
			mapSet();
			map[machine[0].x][machine[0].y]= -1;
			map[machine[1].x][machine[1].y]= -1;
			// 공기 청정기 작동
			refresh();
		}

		// 남은 미세먼지의 양 계산
		int count = 0;
		for(int i = 0 ; i < N ; i++) {
			//System.out.println(Arrays.toString(map[i]));
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] > 0) {
					count+= map[i][j];
				}
			}
		}
		System.out.println(count);
	}

	static void refresh() {

		// 첫번째 공기청정기
		// 왼쪽 변 아래로 이동
		for(int i = machine[0].x-2 ; i >= 0 ; i--) {
			map[i+1][0] = map[i][0]; 
		}
		// 위쪽 변 왼쪽으로 이동
		for(int i = 1 ; i < M ; i++) {
			map[0][i-1] = map[0][i];
		}
		// 오른쪽 변 위로 이동
		for(int i = 1 ; i <= machine[0].x ; i++) {
			map[i-1][M-1] = map[i][M-1];
		}

		// 아래쪽 변을 오른쪽으로 이동
		for(int i = M-2 ; i >= 1 ; i--) {
			map[machine[0].x][i+1] = map[machine[0].x][i];
		}
		map[machine[0].x][1] = 0;

		// 두번째 공기청정기
		// 왼쪽 변 위로 이동
		for(int i = machine[1].x + 2 ; i < N  ; i++) {
			map[i-1][0] = map[i][0];
		}
		
		// 아래쪽 변을 왼쪽으로 이동
		for(int i = 1 ; i < M ; i++) {
			map[N-1][i-1] = map[N-1][i];
		}
		
		// 오른쪽 변을 아래로 이동
		for(int i = N-2 ; i >= machine[1].x ; i--) {
			map[i+1][M-1] = map[i][M-1];
		}
		// 위쪽 변을 오른쪽으로 이동
		for(int i = M-2 ; i >= 1 ; i--) {
			map[machine[1].x][i+1] = map[machine[1].x][i];
		}
		map[machine[1].x][1] = 0;
	}

	static void mapSet() {

		temp = new int[N][M];

		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] > 0) {
					// 확산되는 양에 따라 repro를 안해도 되는 경우도 있음 일단 해보고 시간 초과뜨면 이거 처리
					repro(i,j);
				}
			}
		}

		map = temp;
	}

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	static void repro(int startX, int startY) {

		ArrayList<Node> list = new ArrayList<Node>();
		int count = 0;
		for(int i = 0 ; i < 4 ; i++) {
			int x = startX + dx[i];
			int y = startY + dy[i];

			if(x >= 0 && x < N && y >= 0 && y < M && map[x][y] != -1) {
				list.add(new Node(x,y));
				count++;
			}
		}

		// 확산되는 미세먼지
		for(Node point : list) {
			temp[point.x][point.y] += map[startX][startY]/5;
		}
		// 해당 칸에 남은 미세먼지
		temp[startX][startY] += map[startX][startY] - (map[startX][startY]/5) * count;
	}

	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}