import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			BigInteger a = new BigInteger(st.nextToken());
			BigInteger b = new BigInteger(st.nextToken());
			
			
			if(a.compareTo(BigInteger.valueOf(0)) == 0 && b.compareTo(BigInteger.valueOf(0)) == 0) {
				break;
			}
			
			BigInteger min = BigInteger.valueOf(0);
			BigInteger max = BigInteger.valueOf(1);
			int count = 0;
			while(true) {
				
				BigInteger fibo = min.add(max);
//				System.out.println(fibo);
//				System.out.println(b);
//				System.out.println(fibo.compareTo(b));
				if(fibo.compareTo(b) > 0) {
					break;
				}
				if(fibo.compareTo(a) >= 0) {
					count++;
				}
				min = max;
				max = fibo;
			}
			sb.append(count).append("\n");	
		}
		
		System.out.print(sb);
		
		
	}
}