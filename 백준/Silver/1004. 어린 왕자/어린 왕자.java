import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		
		for(int test_case = 0 ; test_case < T ; test_case++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			Node[] point = new Node[2];
			
			for(int i = 0 ; i < 2 ; i++) {
				point[i] = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}

			int N = Integer.parseInt(in.readLine());
			
			int total = 0;
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
			
				int count = 0;
				for(int j = 0 ; j < 2 ; j++) {
					if( (Math.pow(point[j].x - x, 2) + Math.pow(point[j].y - y, 2)) <= Math.pow(r, 2)) {
						count++;
					}
				}
				if(count == 1) {
					total++;
//					System.out.println(x + " : " + y);
				}
				else if(count == 2){
//					System.out.println(x + " : " + y);
				}
			}
			sb.append(total+ "\n");
		}

		System.out.println(sb);
	}
	
	static class Node{
		int x;
		int y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}