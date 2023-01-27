import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		HashSet<Integer> set = new HashSet<>();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N ; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}

		int M = Integer.parseInt(in.readLine());

		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < M ; i++) {
			System.out.print(set.contains(Integer.parseInt(st.nextToken())) ? 1 + " " : 0 + " ");
		}


	}
}
