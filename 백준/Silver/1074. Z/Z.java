import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int sum = 0;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		cut(0,0,(int) Math.pow(2,N),r,c);
		
		System.out.println(sum);
		
	}
	
	
	static void cut(int x, int y, int size, int r, int c) {
		
		if(x == r && y == c) {
			return;
		}
		
		int half = size/2;
		
		//1번
		if(x <= r && r < x + half && y <= c && c < y + half) {
			cut(x,y,half,r,c);
			return;
		}
		else {
			sum+= half*half;
		}
		//2번
		if(x <= r && r < x + half && y + half <= c && c < y + size) {
			cut(x,y+half,half,r,c);
			return;
		}
		else {
			sum+= half*half;
		}
		//3번
		if(x+half <= r && r < x + size && y <= c && c < y + half) {
			cut(x+half,y,half,r,c);
			return;
		}
		else {
			sum+= half*half;
		}
//		System.out.println(sum);
//		
//		System.out.println(x + " " + y);
//		System.out.println(half);
//		System.out.println(r + " " + c);
//		System.exit(0);
		//4번
		cut(x+half,y+half,half,r,c);
	}
}