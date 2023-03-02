import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static int[][] temp;
	static int max = 0;
	
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		setWall(0,0,0);
		System.out.println(max);
	}
	
	static void setWall(int cnt, int x, int y) {
		
		// 기저 조건 : 벽을 3개 모두 세운 경우
		if(cnt == 3) {
//			System.out.println("=======");
//			for(int i = 0 ; i < N ; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			VirousCheck();
			return;
		}
		
		// 열을 초과하면 다음 행으로 이동함
		if(y >= M) {
			x++;
			y = 0;
		}
		
		// 행을 초과하면 더이상 진행 불가
		if(x >= N) {
			return;
		}
		
		// 해당 열에서 벽을 세울수 있는 위치 찾기
		for(int j = y ; j < M ; j++) {
			if(map[x][j] == 0) {
				map[x][j] = 1;
				setWall(cnt+1, x, j+1);
				map[x][j] = 0;
			}
		}
		
		// 해당 열에서 벽을 찾지 못하면 다음 행으로 이동
		setWall(cnt, x+1, 0);
	}
	
	static void VirousCheck() {
		
		temp = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			temp[i] = Arrays.copyOf(map[i], M);
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(temp[i][j] == 2) {
					repro(i,j);
				}
			}
		}
		
		int count =0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(temp[i][j] == 0) {
					count++;
				}
			}
		}
		
		max = Math.max(max, count);
		
	}
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	// 2가 나오는 경우 4방탐색으로 번식진행
	static void repro(int startX, int startY) {
		
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(startX, startY));
		
		while(!queue.isEmpty()) {
			
			Node curr = queue.poll();
			
			for(int i = 0 ; i < 4 ; i++) {
				int x = curr.x + dx[i];
				int y = curr.y + dy[i];
				if(x >= 0 && x < N && y >= 0 && y < M && temp[x][y] == 0) {
					queue.add(new Node(x,y));
					temp[x][y] = -1;
				}
			}
		}
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