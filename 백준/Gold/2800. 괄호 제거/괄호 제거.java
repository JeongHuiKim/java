import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	static char[] input;
	static StringBuilder sb = new StringBuilder();
	static Set<String> set = new TreeSet<>();
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		input = in.readLine().toCharArray();
		
		delete(0,false);
		
		for(String a : set) {
			sb.append(a+"\n");
		}
		
		
		System.out.print(sb);
		
	}
	
	static void delete(int startIdx, boolean check) {
		
		if(check) {
			String st = "";
			for(int i = 0 ; i < input.length ; i++) {
				if(input[i] != ' '){
					st = st + input[i];
				}
			}
			if(!set.contains(st)) {
				set.add(st);
//				sb.append(st).append("\n");
			}
		}
		
		
		for(int i = startIdx ; i < input.length ; i++) {
			
			if(input[i] == '(') {
				
				delete(i+1,false);
				
				// 삭제 작업
				int count = 0;
				input[i] = ' ';
				int delete1 = i;
				int delete2 = 0;
				for(int j = i ; j < input.length ; j++) {
					if(count == 0 && input[j] == ')') {
						input[j] = ' ';
						delete2 = j;
						break;
					}
					if(input[j] == '(') {
						count++;
					}
					else if(input[j] == ')') {
						count--;
					}
				}
				delete(i+1,true);
				input[delete1] = '(';
				input[delete2] = ')';
				break;
			}
		}
	}
	
	
}