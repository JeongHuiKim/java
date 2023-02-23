import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] inning;
	static int maxScore;
	static int[] order = new int[9];
	static boolean[] isSelected = new boolean[9];


	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(in.readLine());

		inning = new int[N][9];

		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < 9 ; j++) {
				inning[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		permute(0);
		
		System.out.println(maxScore);

	}

	static void permute(int cnt) {

		if(cnt == 9) {
			if(order[3] != 0) {
				return;
			}
			// 게임을 시작하지
			int score = 0;
			int Idx = 0;
			for(int i = 0 ; i < N ; i++) {
				int[] position = new int[3];
				int outCount = 0;

				while(true) {
					if(Idx == 9) {
						Idx = 0;
					}
					
					if(outCount == 3) {
						break;
					}
					
					switch(inning[i][order[Idx]]) {
					case 0:
						outCount++;
						break;
					default:
						for(int j = 2 ; j >= 0; j--) {
							if(position[j] == 1) {
								if(j + inning[i][order[Idx]] >= 3) {
									score++;
									position[j] = 0;
								}
								else {
									position[j] = 0;
									position[j+inning[i][order[Idx]]] = 1;
								}
							}
						}
						if(inning[i][order[Idx]] == 4) {
							score++;
						}
						else {
							position[inning[i][order[Idx]]-1] = 1;
						}
						
						break;
					}
					
					Idx++;
				}
			}

			maxScore = Math.max(maxScore, score);
			return;
		}

		for(int i = 0 ; i < 9 ; i++) {
			if(isSelected[i]) continue;
			order[cnt] = i;
			isSelected[i] = true;
			permute(cnt+1);
			isSelected[i] = false;
		}
	}
}