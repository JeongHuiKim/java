import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static boolean[] isSelected;
	static char[] input;
	static long max = Long.MIN_VALUE;

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(in.readLine());
		isSelected = new boolean[N/2 + 1];
		input = in.readLine().toCharArray();

		if(N == 1) {
			max = input[0] -'0';
		}
		else if(N == 3) {
			switch(input[1]) {
			case '+':
				max = (input[0] - '0') + (input[2] - '0');
				break;
			case '-':
				max = (input[0] - '0') - (input[2] - '0');
				break;
			case '*':
				max = (input[0] - '0') * (input[2] - '0');
				break;
			}
		}
		else {
			subset(0);
		}

		System.out.println(max);
	}

	static void subset(int cnt) {

		if(cnt >= N/2) {
			max = Math.max(max, cal());
			return;
		}
		isSelected[cnt] = true;
		subset(cnt+2);
		isSelected[cnt] = false;
		subset(cnt+1);
	}

	static long cal() {

		long num = input[0] - '0';
		for(int i = 1 ; i < N-1 ; i+=2) {
			long calcal = input[i+1] - '0';
			if(isSelected[(i+1)/2]) {
				switch(input[i+2]) {
				case '+':
					calcal += (input[i+3] - '0');
					break;
				case '-':
					calcal -= (input[i+3] - '0');
					break;
				case '*':
					calcal *= (input[i+3] - '0');
					break;
				}
			}
			
			switch(input[i]) {
			case '+':
				num += calcal;
				break;
			case '-':
				num -= calcal;
				break;
			case '*':
				num *= calcal;
				break;
			}
			
			if(isSelected[(i+1)/2]) {
				i+=2;
			}
		}

		return num;
	}
}