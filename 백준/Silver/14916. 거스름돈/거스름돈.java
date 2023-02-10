import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		
		int del = 0;
		while(true) {
			
			int T = N;
			
			if(del > N/5) {
				System.out.println(-1);
				return;
			}
			
			int count = 0;
			
			count += (N/5 - del);
			T = T - count * 5;
			
//			System.out.println(count + " "  + T);
			
			count += (T / 2);
			T = T%2;
			
//			System.out.println(count + " "  + T);
			
			if(T != 0) {
				del++;
			}
			else {
				System.out.println(count);
				return;
			}
			
		}
		
		
	}
}