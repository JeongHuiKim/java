import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 1 ; j <= M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(map[i]));
		}
		
		oper = new Node[K];
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(in.readLine());
			oper[i] = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		isSelected = new boolean[K];
		order = new int[K];
		permute(0);
		
		System.out.println(min);
	}
	
	static int N;
	static int M;
	static int K;
	static int[][] map;
	static int[][] map_temp;
	static Node[] oper;
	static boolean[] isSelected;
	static int[] order;
	static int min = Integer.MAX_VALUE;
	
	static void permute(int cnt) {
		if(cnt == K) {
			map_temp = new int[N+1][M+1];
			for(int i = 1 ; i <= N ; i++) {
				map_temp[i] = Arrays.copyOf(map[i], M+1);
			}
			rotate();
			return;
		}
		
		for(int i = 0 ; i < K ; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				order[cnt] = i;
				permute(cnt+1);
				isSelected[i] = false;
			}
		}
	}
	
	static void rotate() {
		
		for(int k = 0 ; k < K ; k++) {
//			System.out.println(oper[k].toString());
			int x = oper[order[k]].r - oper[order[k]].s;
			int y = oper[order[k]].c - oper[order[k]].s;
			int H = oper[order[k]].s * 2;
//			System.out.println("===" + x + " " + y + " " + H);
			
			for(int r = 0 ; r < oper[order[k]].s ; r++) {
				int temp = map_temp[x][y];
				
				// 위로
				for(int i = 0 ; i < H ; i++) {
					map_temp[x+i][y] = map_temp[x+1+i][y];
				}
				// 왼쪽으로
				for(int i = 0 ; i < H ; i++) {
					map_temp[x+H][y+i] = map_temp[x+H][y+i+1];
				}
				// 아래로
				for(int i = 0 ; i < H ; i++) {
					map_temp[x+H-i][y+H] = map_temp[x+H-i-1][y+H];
				}
				// 오른쪼긍로
				for(int i = 0 ; i < H ; i++) {
					map_temp[x][y+H-i] = map_temp[x][y+H-i-1];
				}
				
				map_temp[x][y+1] = temp;
				x++;
				y++;
				H-=2;
			}
		}
		
		
		
		for(int i = 1 ; i <= N ; i++) {
			int sum = 0;
			for(int j = 1 ; j <= M ; j++) {
				sum += map_temp[i][j];
//				System.out.print(map_temp[i][j] + " ");
			}
//			System.out.println();
			min = Math.min(min, sum);
		}
	}
	
	static class Node{
		int r;
		int c;
		int s;
		Node(int r, int c, int s){
			this.r = r;
			this.c = c;
			this.s = s;
		}
		
		@Override
		public String toString() {
			
			return r + " " + c + " " + s;
		}
	}
	
}

//5 6 1
//1 2 3 2 5 6
//3 8 7 2 1 3
//8 2 3 1 4 5
//3 4 5 1 1 1
//9 3 2 1 4 3
//3 4 2