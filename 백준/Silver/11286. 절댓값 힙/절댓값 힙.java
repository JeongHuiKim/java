import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2)) {
					return o1-o2;
				}
				return Math.abs(o1) - Math.abs(o2);
			}

		});

		int N = Integer.parseInt(in.readLine());

		for(int i = 0 ; i < N ; i++) {

			int input = Integer.parseInt(in.readLine());

			switch(input) {
			case 0:
				if(!queue.isEmpty()) {
					sb.append(queue.poll()).append("\n");
				}
				else {
					sb.append("0\n");
				}
				break;
			default:
				queue.offer(input);
				break;
			}
		}
		
		System.out.print(sb);
	}

}