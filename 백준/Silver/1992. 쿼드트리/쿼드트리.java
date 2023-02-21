import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int[][] video;
	
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		video = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			char[] input = in.readLine().toCharArray();
			for(int j = 0; j< N ; j++) {
				video[i][j] = input[j] - '0';
			}
		}
		
		div(0,0,N);
		
		System.out.println(sb);
	}
	
	static void div(int r, int c, int size) {
//		System.out.println(r + " " + c + " " + size);
		
		int sum = 0;
		for(int i = r ; i < r+size ; i++) {
			for(int j = c ; j < c+size ; j++) {
				sum += video[i][j];
			}
		}
		
		// 모두 같은 부분이 아니라면 4분할
		if(sum != 0 && sum != size*size) {
			sb.append("(");
			int half = size/2;
			
			div(r,c,half);
			div(r,c+half,half);
			div(r+half,c,half);
			div(r+half, c+half,half);
			
			sb.append(")");
		}
		// 아니면 출력
		else {
			sb.append(sum / (size*size) );
		}
		
		
		
	}
}