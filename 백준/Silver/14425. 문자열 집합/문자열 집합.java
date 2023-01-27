import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		HashSet<String> set = new HashSet<>();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < N ; i++) {
			set.add(in.readLine());
		}
		
		int count = 0;
		
		for(int i = 0 ; i < M ; i++) {
			if(set.contains(in.readLine())) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
}
