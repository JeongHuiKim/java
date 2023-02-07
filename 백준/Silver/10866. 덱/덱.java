import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		List<String> list = new ArrayList<>();
		
		int N =  Integer.parseInt(in.readLine());

		for(int i = 0 ; i < N ; i++ ) {
			String[] input = in.readLine().split(" ");

			switch(input[0]) {
			case "push_front":
				list.add(0, input[1]);
				break;
			case "push_back":
				list.add(input[1]);
				break;
			case "pop_front":
				if(list.isEmpty()) {
					sb.append("-1\n");
				}
				else {
					sb.append(list.remove(0)).append("\n");
				}
				break;
			case "pop_back":
				if(list.isEmpty()) {
					sb.append("-1\n");
				}
				else {
					sb.append(list.remove(list.size()-1)).append("\n");
				}
				break;
			case "size":
				sb.append(list.size()).append("\n");
				break;
			case "empty":
				sb.append( list.isEmpty() ? "1\n" : "0\n");
				break;
			case "front":
				if(list.isEmpty()) {
					sb.append("-1\n");
				}
				else {
					sb.append( list.get(0)).append("\n");
				}
				break;
			case "back":
				if(list.isEmpty()) {
					sb.append("-1\n");
				}
				else {
					sb.append( list.get(list.size()-1)).append("\n");
				}
				break;
			}
		}

		System.out.print(sb);

	}	
}