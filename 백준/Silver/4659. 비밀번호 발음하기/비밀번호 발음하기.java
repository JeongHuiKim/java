import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			
			String input = in.readLine();
			
			if(input.equals("end")) {
				break;
			}
			
			sb.append("<" + input);
			
			boolean isbreak = false;
			boolean containMo = false;
			int repeatMoCount = 0;
			int repeatJaCount = 0;
			int eCount = 0 ;
			int oCount = 0;
			
			char prev = '0';
			for(char st : input.toCharArray()) {
				
				switch(st) {
				case 'e':
				case 'o':
				case 'a':
				case 'i':
				case 'u':
					if(st == 'e') {
						eCount++;
						oCount = 0;
					}
					else if(st == 'o') {
						oCount++;
						eCount = 0;
					}
					else {
						eCount = 0;
						oCount = 0;
					}
					
					containMo = true;
					repeatMoCount++;
					repeatJaCount = 0;
					break;
				default:
					repeatJaCount++;
					repeatMoCount = 0;
					eCount = 0;
					oCount = 0;
					break;
				}
				
				if(repeatMoCount >= 3 || repeatJaCount >= 3 || eCount >= 3 || oCount >= 3) {
					sb.append("> is not acceptable.\n");
					isbreak = true;
					break;
				}
				if(prev == st && st != 'e' && st != 'o') {
					sb.append("> is not acceptable.\n");
					isbreak = true;
					break;
				}
				prev = st;
			}
			
			if(!isbreak) {
				if(containMo) {
					sb.append("> is acceptable.\n");
				}
				else {
					sb.append("> is not acceptable.\n");
				}
			}
		}
		
		
		System.out.print(sb);
		
	}
}