import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] map= new int[2*Math.max(M, N)];
		
		bfs(map, N, M);
	}
	
	static void bfs(int[] map, int N, int M) {
		
		ArrayDeque<Node> queue = new ArrayDeque<>();
		queue.add(new Node(N,1));
		
		while(!queue.isEmpty()){
			Node curr = queue.poll();
//			System.out.println(curr.x);
//			if(curr.x == M) {
//				System.out.println(curr.depth-1);
//				System.exit(0);
//			}
			
			if(curr.x < 2*Math.max(M, N) && curr.x >= 0 && (map[curr.x] == 0 || map[curr.x] > curr.depth )) {
				map[curr.x] = curr.depth;
				queue.add(new Node(curr.x*2, curr.depth));
				queue.add(new Node(curr.x+1, curr.depth+1));
				queue.add(new Node(curr.x-1, curr.depth+1));
			}
			
		}
//		System.out.println(Arrays.toString(map));
		System.out.println(map[M]-1);
	}
	
	static class Node{
		int x;
		int depth;
		
		Node(int x, int depth){
			this.x = x;
			this.depth = depth;
		}
	}
}