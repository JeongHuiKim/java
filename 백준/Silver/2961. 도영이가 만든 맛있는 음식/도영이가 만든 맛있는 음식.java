import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] Sin; // 곱하기 
	static int[] Cen; // 더하기
	static boolean[] isSelected;
	
	static int Min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		Sin = new int[N];
		Cen = new int[N];
		isSelected = new boolean[N];
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			Sin[i] = Integer.parseInt(st.nextToken());
			Cen[i] = Integer.parseInt(st.nextToken());
		}
		
		cook(0, 1 ,0);
		
		System.out.println(Min);
	}
	
	private static void cook(int cnt, int sin, int cen) {
		
		if(cnt == N) {
			if( sin != 1 && cen != 0) {
				int cal = Math.abs(sin-cen);
				Min = Math.min(Min, cal);
			}
			return;
		}
		else {	
			isSelected[cnt] = true;
			cook(cnt+1, sin * Sin[cnt] , cen + Cen[cnt]);
			isSelected[cnt] = false;
			cook(cnt+1, sin, cen);
		}
	}
}