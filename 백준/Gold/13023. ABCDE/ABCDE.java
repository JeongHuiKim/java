import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] list;
	static boolean[] isSelected;
	
	
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N];
		isSelected = new boolean[N];
		
		for(int i = 0 ; i < N ; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i = 0 ; i < N ; i++) {
			isSelected[i] = true;
			dfs(i,0);
			isSelected[i] = false;
		}
		
		System.out.println(0);
		
	}
	
	static void dfs(int start, int cnt) {
		
		if(cnt == 4) {
			System.out.println(1);
			System.exit(0);
		}
		
		for(int i = 0 ; i < list[start].size() ; i++) {
			int Idx = list[start].get(i);
			// 선택되지 않은 친구이면
			if(!isSelected[Idx]) {
				isSelected[Idx] = true;
				dfs(Idx, cnt + 1);
				isSelected[Idx] = false;
			}
		}
	}
}