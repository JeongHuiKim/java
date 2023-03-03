import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int R;
	static int C;
	static int M;

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		PriorityQueue<Shark> queue = new PriorityQueue<Shark>();

		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(in.readLine());
			queue.add(new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int fishingSize = 0;

		// R이 행, C가 열
		for(int k = 1 ; k <= C ; k++) {

			/**
			 * 낚시왕의 낚시 진행
			 */
			// 새로 상어를 담을 우선순위 큐
			PriorityQueue<Shark> temp = new PriorityQueue<Shark>();
			boolean check = false;
			while(!queue.isEmpty()) {
				Shark curr = queue.poll();
				if(!check && curr.y == k) {
					check = true;
					fishingSize += curr.size;
				}
				else {
					temp.add(curr);
				}
			}

			/**
			 * 상어 대이동 진행
			 */

			// 격자에 표시할꺼얌
			Shark[][] map = new Shark[R+1][C+1];
			// 모든 상어를 다 확인하면서 진행
			while(!temp.isEmpty()) {
				Shark curr = temp.poll();
				//System.out.println(curr.x + " " + curr.y + " " + curr.size);
				// 시간 초과 해결 부분 (이동 횟수를 나머지 연산을 통해 줄이자)
				int seconds = 0;
				// 위 혹은 아래 방향이면
				if (curr.dir == 1 || curr.dir == 2) {
					seconds = curr.speed % ((R - 1) * 2);
				}
				// 오른쪽 혹은 왼쪽 방향이면
				else if (curr.dir == 3 || curr.dir == 4) {
					seconds = curr.speed % ((C - 1) * 2);
				}

				// 1초씩 이동
				for (int i = 0; i < seconds; i++) {
					int x = curr.x + dx[curr.dir];
					int y = curr.y + dy[curr.dir];

					// 경계 안쪽이면 이동
					if ((0 < x && x <= R) && (0 < y && y <= C)) {
						curr.x = x;
						curr.y = y;
					}
					// 경계 밖이면 방향 전환
					else {
						// 위 혹은 아래 방향이면
						if (curr.dir == 1 || curr.dir == 2) {
							curr.dir = curr.dir == 1 ? 2 : 1;  // 위 아래 방향 전환 
						}
						// 오른쪽 혹은 왼쪽 방향이면
						else if (curr.dir == 3 || curr.dir == 4) {
							curr.dir = curr.dir == 3 ? 4 : 3;  // 오른쪽 왼쪽 방향 전환
						}

						// 전환한 방향으로 이동
						curr.x += dx[curr.dir];
						curr.y += dy[curr.dir];
					}
				}

				if(map[curr.x][curr.y] == null) {
					map[curr.x][curr.y] = curr;
				}
				else {
					if(map[curr.x][curr.y].size < curr.size) {
						map[curr.x][curr.y] = curr;
					}
				}
			}
			
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if (map[i][j] != null) {
						queue.offer(map[i][j]);
					}
				}
			}
		
		}

		System.out.println(fishingSize);

	}

	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,1,-1};

	static class Shark implements Comparable<Shark>{
		int x;
		int y;
		int speed;
		int dir;
		int size;
		Shark(int x, int y, int speed, int dir, int size){
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
		@Override
		public int compareTo(Shark o) {

			// 같으면 x로 정렬, 작을수록 먼저
			if(o.x == this.x) {
				// 같으면 size로 정렬, 클수록 먼저
				return o.size - this.size;
			}
			return this.x - o.x;

		}
	}
}