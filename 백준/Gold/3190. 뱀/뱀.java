import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	// 위 : 0 , 오른쪽 : 1, 아래  : 2, 왼쪽 : 3
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		// 보드의 크기 
		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[N+1][N+1];

		// 사과의 갯수
		int K = Integer.parseInt(in.readLine());
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 2;
		}

		map[1][1] = 1;

		ArrayDeque<Node> deque = new ArrayDeque<>();
		deque.add(new Node(1,1));

		int GameTime = 1;
		int dir = 1;
		
//		for(int m = 1 ; m <= N ; m++) {
//			System.out.println(Arrays.toString(map[m]));
//		}

		// 뱀의 방향 전환 횟수
		int L = Integer.parseInt(in.readLine());
		for(int i = 0 ; i < L ; i++) {
			st = new StringTokenizer(in.readLine());
			int count = Integer.parseInt(st.nextToken());
			String D = st.nextToken();

			// 전진하장
			while(count >= GameTime){
				Node head = deque.peekFirst();
				int x = head.x + dx[dir];
				int y = head.y + dy[dir];
				// map의 범위를 만족하고 자신에 부딧치지 않는 경우
				if(x >= 1 && x <= N && y >= 1 && y <= N && map[x][y] != 1) {
					// 사과를 먹는 경우
					if(map[x][y] == 2) {
						deque.addFirst(new Node(x,y));
						map[x][y] = 1;
					}
					// 그냥 지나가는 경우
					else {
						deque.addFirst(new Node(x,y));
						map[x][y] = 1;
						Node poll = deque.pollLast();
						map[poll.x][poll.y] = 0;
					}					
//					System.out.println("\n=========  " + GameTime + "  ===========");
//					for(int m = 1 ; m <= N ; m++) {
//						System.out.println(Arrays.toString(map[m]));
//					}
					GameTime++;
				}
				else {
					System.out.println(GameTime);
					System.exit(0);
				}
				
			}
			// 방향 설정
			switch(D) {
			case "D":
				dir++;
				if(dir == 4) {
					dir = 0;
				}
				break;
			case "L":
				dir--;
				if(dir == -1) {
					dir = 3;
				}
				break;
			}
		}
		
		while(true) {
			Node head = deque.peekFirst();
			int x = head.x + dx[dir];
			int y = head.y + dy[dir];
			// map의 범위를 만족하고 자신에 부딧치지 않는 경우
			if(x >= 1 && x <= N && y >= 1 && y <= N && map[x][y] != 1) {
				// 사과를 먹는 경우
				if(map[x][y] == 2) {
					deque.addFirst(new Node(x,y));
					map[x][y] = 1;
				}
				// 그냥 지나가는 경우
				else {
					deque.addFirst(new Node(x,y));
					map[x][y] = 1;
					Node poll = deque.pollLast();
					map[poll.x][poll.y] = 0;
				}				
//				System.out.println("\n=========  " + GameTime + "  ===========");
//				for(int m = 1 ; m <= N ; m++) {
//					System.out.println(Arrays.toString(map[m]));
//				}
				GameTime++;
			}
			else {
				System.out.println(GameTime);
				System.exit(0);
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