import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static char[][] map;
	static boolean[][] visited;
	static int R;
	static int C;
	static int count = 0;

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];

		for(int i = 0 ; i < R ; i++) {
			map[i] = in.readLine().toCharArray();
		}

		for(int i = 0 ; i < R ; i++) {
			dfs(i,0);
		}
		System.out.println(count);
	}

	static int[] dx = { -1, 0 , 1};
	static int[] dy = {1,1,1};

	static boolean dfs(int x, int y) {

		// 내 빵집에 도착하면 다음 파이프로 넘어가서 탐색해야됨
		if(y == C-1) {
			count++;
			return true;
		}

		// 유도부분
		// 0 : 오른쪽 대각선 위 이동
		// 1 : 오른쪽 이동
		// 2 : 오른쪽 대각선 아래 이동

		for(int i = 0 ; i < 3 ; i++) {
			int goX = x + dx[i];
			int goY = y + dy[i];

			if(goX >= 0 && goX < R && goY >= 0 && goY < C && !visited[goX][goY] && map[goX][goY] != 'x') {
				visited[goX][goY] = true;
				if(dfs(goX,goY)) {
					return true;
				}
			}
		}
		return false;
	}
}