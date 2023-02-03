import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		List<String> list = new ArrayList<>();
		
		for(int i = 0 ; i < N ; i++) {
			String input = in.readLine();
			if(!list.contains(input)) {
				list.add(input);
			}
		}
		
		Collections.sort(list, new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length() - o2.length();
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < list.size() ; i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		System.out.print(sb);
		
	}
	
	
	
}