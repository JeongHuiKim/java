import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int[][] temp;
	static int N;
	static int M;
	static int D;
	static int total_monster;
	static boolean[] isSelected;
	static Node[] monster = new Node[3];
	static int maxKill = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		isSelected = new boolean[M];
		map = new int[N+1][M];

		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					total_monster++;
				}
			}
		}

		combi(0,0);

		
		System.out.println(maxKill);
	}

	static void combi(int cnt, int start) {

		if(cnt == 3) {
			temp = new int[N+1][M];
			
			for(int i = 0 ; i <= N ; i++) {
				temp[i] = Arrays.copyOf(map[i], M);
			}
			
			int killed = 0;
			int arrive = 0;

			int kkk = 0;
			// while문 들어가야됨
			while(true) {
				int count = 0; // 몇번째 monster인지 저장할꺼임
				for(int i = 0 ; i < M ; i++){
					if(isSelected[i]) {
						// 공격할 적 3명을 찾아줌
						find(i,count++);
					}
				}

				// 적 3명 죽임
				for(Node mon : monster) {
					if(mon.x != -1 && temp[mon.x][mon.y] == 1) {
						killed++;
						temp[mon.x][mon.y] = 0;
					}
				}

				//한 칸씩 앞으로 땡겨줌
				for(int i = N-1 ; i >= 0 ; i--) {
					temp[i+1] = Arrays.copyOf(temp[i], M);
				}
				
				for(int i = 0 ; i < M ; i++) {
					temp[0][i] = 0;
				}
				
				// 몬스터가 성에 도착하면 게임 끝
				for(int i = 0 ; i < M ; i++) {
					if(temp[N][i] == 1) {
						arrive++;
						temp[N][i] = 0;
					}
				}
				
//				System.out.println("========================");
//				for(int k = 0 ; k <= N ; k++) {
//					for(int j = 0 ; j < M ; j++) {
//						System.out.print(temp[k][j]);
//					}
//					System.out.println();
//				}
//				System.out.println(killed + "+" + arrive +" : " + total_monster);
//				kkk++;
//				if(kkk==2) {
//					System.exit(0);
//				}
				
				if( (killed+arrive) == total_monster) {
					maxKill = Math.max(maxKill, killed);
					return;
				}
			}
			
		}


		for(int i = start ; i < M ; i++) {
			isSelected[i] = true;
			combi(cnt+1, i+1);
			isSelected[i] = false;
		}

	}

	static int[] dx = {0,-1,0};
	static int[] dy = {-1,0,1};

	static void find(int positionX, int Idx ) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(N,positionX,0));

		boolean[][] visited = new boolean[N][M];

		while(!queue.isEmpty()) {

			Node curr = queue.poll();

			if(temp[curr.x][curr.y] == 1) {
				monster[Idx] = new Node(curr.x, curr.y,0);
				return;
			}

			if(curr.depth == D) {
				continue;
			}

			for(int i = 0 ; i < 3 ; i++) {
				int x = curr.x + dx[i];
				int y = curr.y + dy[i];

				if(x >= 0 && x < N && y >= 0 && y < M && !visited[x][y]) {
					queue.add(new Node(x,y,curr.depth+1));
					visited[x][y] = true;
				}
			}
		}
		
		monster[Idx] = new Node(-1, 0,0);
	}

	static class Node{
		int x;
		int y;
		int depth;

		Node(int x, int y, int depth){
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
}