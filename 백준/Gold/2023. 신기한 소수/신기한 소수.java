import java.util.Scanner;

public class Main {

	static int N;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		int[] nums = {2,3,5,7};
		
		for(int num : nums) {
			cal(num, 1);
		}
		
	}
	
	static void cal(int num, int cnt) {
		
		if(cnt == N) {
			System.out.println(num);
			return;
		}
		
		num *= 10;
		
		for(int i = 0 ; i < 10 ; i++) {
			if(check(num+i)) {
				cal(num+i,cnt+1);
			}
		}
	}
	
	
	static boolean check(int num) {
		
		boolean[] isNum = new boolean[(int) Math.sqrt(num)+2];
		
		for(int i = 2 ; i <= Math.sqrt(num) ; i++) {
			if(!isNum[i]) {
				if( num % i != 0 ) {
					
					int c = i;
					
					while( c <= Math.sqrt(num) ) {
						isNum[c] = true;
						c += i;
					}
				}
				else {
					return false;
				}
			}
		}
		
		return true;
	}
}