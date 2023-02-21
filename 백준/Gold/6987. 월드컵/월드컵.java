import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] win = new int[6];
	static int[] drow = new int[6];
	static int[] loss = new int[6];

	static int[] win_ans = new int[6];
	static int[] drow_ans = new int[6];
	static int[] loss_ans = new int[6];

	static boolean[][] visited = new boolean[6][6];

	static boolean check = false;

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int k = 0 ; k < 4 ; k++) {
			String[] input = in.readLine().split(" ");
			int idx=0;
			for(int i = 0 ; i < 6 ; i++) {
				win[i] = Integer.parseInt(input[idx++]);
				drow[i] = Integer.parseInt(input[idx++]);
				loss[i] = Integer.parseInt(input[idx++]);
			}

			for(int i = 0 ; i < 6 ; i++) {
				for(int j = 0 ; j <= i ; j++) {
					visited[i][j] = true;
				}
			}
			
			check = false;
			permute(0, 1);

			if(check) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
		}
		

	}

	static void permute(int homeTeam, int awayTeam) {

		if(homeTeam == 6) {
			check = true;
			return;
		}

		if(awayTeam == 6) {
			int sum = win[homeTeam] + loss[homeTeam] + drow[homeTeam];
			if(sum == 5) {
				permute(homeTeam+1,0);
			}
			return;
		}

		
		if(visited[homeTeam][awayTeam]) {
			permute(homeTeam,awayTeam+1);
			return;
		}
		
		// 이기는 경우
		if(win[homeTeam] > win_ans[homeTeam] && loss[awayTeam] > loss_ans[awayTeam]) {
			win_ans[homeTeam]++;
			loss_ans[awayTeam]++;
			permute(homeTeam,awayTeam+1);
			win_ans[homeTeam]--;
			loss_ans[awayTeam]--;
		}
		// 비기는 경우
		if(drow[homeTeam] > drow_ans[homeTeam] && drow[awayTeam] > drow_ans[awayTeam]) {
			drow_ans[homeTeam]++;
			drow_ans[awayTeam]++;
			permute(homeTeam,awayTeam+1);
			drow_ans[homeTeam]--;
			drow_ans[awayTeam]--;
		}
		// 지는 경우
		if(loss[homeTeam] > loss_ans[homeTeam] && win[awayTeam] > win_ans[awayTeam]) {
			loss_ans[homeTeam]++;
			win_ans[awayTeam]++;
			permute(homeTeam,awayTeam+1);
			loss_ans[homeTeam]--;
			win_ans[awayTeam]--;
		}
	}
}