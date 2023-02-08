import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	static int i;
	static Stack<String> stack;
	static String input;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for(int test_case = 0; test_case < T ; test_case++) {

			char[] fn = in.readLine().toCharArray();

			int N = Integer.parseInt(in.readLine());

			Deque<String> list = new LinkedList<>();

			String input = in.readLine();

			for(String st : input.substring(1,input.length()-1).split(",")){
				if(st.equals("")) {
					continue;
				}
				list.add(st);
			}

			//			System.out.println(list.size());

			// true -> 앞쪽
			boolean dir = true;

			boolean check = true;

			for(char ch : fn) {
				if(ch == 'R') {
					dir = !dir;
				}
				else {
					if(list.size() == 0) {
						check = false;
						sb.append("error\n");
						break;
					}
					if(dir) {
						list.pollFirst();
					}
					else {
						list.pollLast();
					}
				}
			}
			if(check) {
				if(list.size()==0) {
					sb.append("[]\n");
					continue;
				}
				sb.append("[");
				if(!dir) {
					while(!list.isEmpty()) {
						sb.append(list.pollLast() + ",");
					}
				}
				else {
					while(!list.isEmpty()) {
						sb.append(list.pollFirst() + ",");
					}
				}
				sb.replace(sb.length()-1, sb.length(), "]\n");
			}
		}
		System.out.print(sb);

	}
}