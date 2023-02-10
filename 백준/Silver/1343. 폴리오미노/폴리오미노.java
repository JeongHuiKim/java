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
		
		String input = in.readLine();
		
		
		input = input.replace("XXXX", "AAAA");
		input = input.replace("XX", "BB");
		
		for(int i = 0 ; i < input.length() ; i++) {
			if(input.charAt(i) == 'X') {
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(input);
		
	}
}