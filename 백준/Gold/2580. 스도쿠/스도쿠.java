import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int[][] sudo;
	static int M;

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sudo = new int[10][10];
		M = 0;
		for(int i = 1 ; i <= 9 ; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 1 ; j <= 9 ; j++) {
				sudo[i][j] = Integer.parseInt(st.nextToken());
				if(sudo[i][j] == 0) {
					M++;
				}
			}
		}

		combi(1, 1);
	}

	static void combi(int row, int col) {
		
		// col이 범위를 넘어가는 경우 다음 row로 넘어감
		if(col == 10) {
			row++;
			col = 1;
		}
		
		// 기저 조건   :  row가 10이라는 뜻은 9번 row까지 탐색을 모두 마쳤다는 의미임, 즉 스도쿠 완성
		if(row == 10) {
			// 스도쿠 출력
			for(int i = 1 ; i < 10 ; i++) {
				for(int j = 1 ; j < 10 ; j++) {
					sb.append(sudo[i][j] + " ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
			System.exit(0);
			return;
		}
		
		// 유도 조건
		// sudo가 0이 아니면 그냥 바로 넘어가면 됨
		if(sudo[row][col] != 0) {
			combi(row, col+1);
		}
		// 0이면 가로,세로, 네모를 확인하고 숫자를 찾아줘야함
		else {
			//가로, 세로, 네모 칸 확인해서 해당 자리에 올 수 있는 숫자를 찾아야함
			boolean[] isSelected = new boolean[10];
			
			// 가로 세로 확인
			for(int i = 1 ; i < 10 ; i++) {
				isSelected[sudo[row][i]] = true;
				isSelected[sudo[i][col]] = true;
			}
			
//			System.out.print("(" + row + ", " + col + ") : ");
			
			int x = ((row-1) / 3) * 3;
			int y = ((col-1) / 3) * 3;
			for(int i = x+1 ; i < x+4 ; i++) {
				for(int j = y+1 ; j < y+4 ; j++) {
					isSelected[sudo[i][j]] = true;
				}
			}
//			
//			
//			for(int i = 1 ; i < 10 ; i++) {
//				if(!isSelected[i]) {
//					System.out.print(i + " ");
//				}
//			}
//			System.out.println();
//			
			for(int i = 1 ; i < 10 ; i++) {
				if(!isSelected[i]) {
					sudo[row][col] = i;
					combi(row,col+1);
				}
			}
			sudo[row][col] = 0;
		}
	}
}