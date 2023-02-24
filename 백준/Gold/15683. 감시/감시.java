import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static ArrayList<Node> list;
	static int minCount = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		list = new ArrayList<>();
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] >= 1 && map[i][j] <= 5) {
					list.add(new Node(i,j,map[i][j]));
				}
			}
		}
		
		find(0, map);
		
		System.out.println(minCount);
	}
	
	static void find(int cnt, int[][] map) {
//		System.out.println(cnt + " " + list.size());
		// 기저 조건 - CCTV를 모두 돌면 사각지대를 확인함, 여기서 사각지대는 숫자 0임
		if(cnt == list.size()) {
			int count = 0;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(map[i][j] == 0) {
						count++;
					}
				}
			}
			minCount = Math.min(minCount, count);
			return;
		}

		Node curr = list.get(cnt);
		
		int[][] temp = new int[N][M];
		
		// 해당 CCTV의 가능한 방향 조합들 돌아가면서 확인
		for(int i = 0 ; i < dx[curr.CCTV].length ; i++) {
			// 넘겨줄 temp 배열 생성
			for(int k = 0 ; k < N ; k++) {
				temp[k] = Arrays.copyOf(map[k], M);
			}
			// 해당 방향으로 CCTV 확인 작업
			for(int j = 0 ; j < dx[curr.CCTV][i].length ; j++) {
//				System.out.println(cnt + " " + dx[curr.CCTV].length + " " +  dx[curr.CCTV][i].length);
				int x = curr.x;
				int y = curr.y;
				
				while(true) {
					x += dx[curr.CCTV][i][j];
					y += dy[curr.CCTV][i][j];
					
					if(x >= 0 && x < N && y >=0 && y < M && temp[x][y] != 6) {
						if(temp[x][y] == 0) {
							temp[x][y] = -1;
						}
						else {
							continue;
						}
					}
					else {
						break;
					}
				}
			}
			
//			System.out.println("=======" + cnt + "===========");
//			for(int k = 0 ; k < N ; k++) {
//				System.out.println(Arrays.toString(temp[k]));
//			}
			// 모든 방향으로 CCTV탐색이 끝났으면 다음 CCTV로 넘어가야됨
			find(cnt+1, temp);
		}
	}
	
	static class Node{
		int x;
		int y;
		int CCTV;
		Node(int x, int y, int CCTV){
			this.x = x;
			this.y = y;
			this.CCTV = CCTV;
		}
	}
	
	static int[][][] dx = { {}, { {1}, {0}, {-1}, {0} }, { {1, -1}, {0, 0} }, 
			{ {1, 0}, {0, -1}, {-1, 0}, {0, 1} } ,{ { 1, 0, -1 }, { 1, 0, 0 }, { 1, -1, 0 }, { 0, -1, 0 } },
			{ { 1, 0, -1, 0 } } };
	static int[][][] dy = { {}, { {0}, {1}, {0}, {-1} }, { {0, 0}, {1, -1} },
			{ {0 ,1}, {1, 0}, {0, -1}, {-1, 0} }, { { 0, 1, 0 }, { 0, 1, -1 }, { 0, 0, -1 }, { 1, 0, -1 } },
			{ { 0, 1, 0, -1 } } };
}




//  상, 우, 하, 좌
// { 1, 0, -1, 0 }
// { 0, 1, 0, -1 }

// 1번
// { {1}, {0}, {-1}, {0} }
// { {0}, {1}, {0}, {-1} }

// 2번
// { {1, -1}, {0, 0} }
// { {0, 0}, {1, -1} }

// 3번
// { {1, 0}, {0, -1}, {-1, 0}, {0, 1} } 
// { {0 ,1}, {1, 0}, {0, -1}, {-1, 0} }

// 4번 
// { { 1, 0, -1 }, { 1, 0, 0 }, { 1, -1, 0 }, { 0, -1, 0 } }
// { { 0, 1, 0 }, { 0, 1, -1 }, { 0, 0, -1 }, { 1, 0, -1 } }

// 5번
// { { 1, 0, -1, 0 } }
// { { 0, 1, 0, -1 } }