import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static Queue<String> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String input = in.readLine();

		int N = Integer.parseInt(in.readLine());

		for(int i = 0 ; i < N ; i++) {
			queue.add(in.readLine());
		}

		// 1. 지역 코드 확인(6자리)
		if(!areaCheck(input.substring(0, 6))) {
			System.out.println("I");
			System.exit(0);
		}

		// 2. 생일 코드 확인(8자리)
		if(!birthCheck(input.substring(6, 14))) {
			System.out.println("I");
			System.exit(0);
		}

		// 3. 순서 코드 확인(3자리)
		String orderCode = input.substring(14, 17);
		if(orderCode.equals("000")) {
			System.out.println("I");
			System.exit(0);
		}

		// 4. 체크섬
		if(!checksum(input)) {
			System.out.println("I");
			System.exit(0);
		}

		// 모두 통과하면 유효한 신분증
		if(Integer.parseInt(orderCode) % 2 == 0) {
			System.out.println("F");
		}
		else {
			System.out.println("M");
		}

	}

	static boolean areaCheck(String area) {
		return queue.contains(area) ? true : false;
	}

	static boolean birthCheck(String birth) {

		int year = Integer.parseInt(birth.substring(0, 4));
		int month = Integer.parseInt(birth.substring(4, 6));
		int day = Integer.parseInt(birth.substring(6, 8));

		if(year < 1900 || year > 2011) {
			return false;
		}

		if(month > 12 || month < 1) {
			return false;
		}

		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if(day > 31 || day < 1) {
				return false;
			}
			break;
		case 2:
			if(year % 4 == 0 && year != 1900) {
				if(day > 29 || day < 1) {
					return false;
				}
			}
			else {
				if(day > 28 || day < 1) {
					return false;
				}
			}
			break;
		default:
			if(day > 30 || day < 1) {
				return false;
			}
			break;
		}
		
		if(year == 1900 && month == 1 && day == 1) {
			return false;
		}
		if(year == 2011 && month == 12 && day == 31) {
			return false;
		}
		return true;
	}

	static boolean checksum(String input) {
		long sum = 0;
		for(int i = 0 ; i < 17 ; i++) {
			sum += (Integer.parseInt(input.substring(i,i+1)) * Math.pow(2, 17-i));
			sum %= 11;
		}

		if(input.substring(17, 18).equals("X")) {
			sum += 10;
			sum %= 11;
			if(sum != 1) {
				return false;
			}
		}
		else {
			sum += Integer.parseInt(input.substring(17, 18));
			sum %= 11;
			if(sum != 1 ) {
				return false;
			}
		}

		return true;
	}
}