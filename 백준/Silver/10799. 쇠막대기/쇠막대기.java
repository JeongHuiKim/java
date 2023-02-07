import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = in.readLine().toCharArray();
		
		int count = 0;
		
		int total = 0;
		for(int i = 0 ; i < input.length ; i++) {
			if(input[i] == '(') {
				if(input[i+1] == ')') {
					total += count;
					i++;
				}
				else {
					count++;
				}
			}
			else {
				count--;
				total++;
			}
		}
		
		System.out.println(total);
		
	}
}