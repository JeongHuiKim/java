import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb = new StringBuilder();
	
	static int N;
	
	static String[] last = {"\"재귀함수가 뭔가요?\""
							, "\"재귀함수는 자기 자신을 호출하는 함수라네\""
							, "라고 답변하였지." };
	static String[] word = {"\"재귀함수가 뭔가요?\""
							,"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어."
							,"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지."
							,"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""};
	
	private static void chatbot(int n ) {
		
		// 기저 조건
		if(n == 0) {
			for(int j = 0 ; j < last.length ; j++) {
				setBar(n);
				sb.append(last[j]).append("\n");
			}
			return;
		}
		// 요구 조건
		for(int j = 0 ; j < word.length ; j++) {
			setBar(n);
			sb.append(word[j]).append("\n");
		}
		
		chatbot(n-1);
		
		setBar(n);
		sb.append("라고 답변하였지.").append("\n");
		
	}
	
	private static void setBar(int n) {
		for(int i = 0 ; i < N-n ; i++) {
			sb.append("____");
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
		chatbot(N);
		System.out.print(sb);
	}
}
