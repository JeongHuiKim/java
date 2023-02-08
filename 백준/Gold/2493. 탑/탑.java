import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		
		Stack<Node> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		stack.push(new Node(Integer.parseInt(st.nextToken()),1));
		sb.append(0 + " ");
		
		for(int i = 2 ; i <= N ; i++) {
			int height = Integer.parseInt(st.nextToken());
			while(true) {
				if(stack.isEmpty()) {
					sb.append(0 + " ");
					stack.push(new Node(height, i));
					break;
				}
				
				if(stack.peek().height > height) {
					sb.append(stack.peek().index + " ");
					stack.push(new Node(height, i));
					break;
				}
				else {
					stack.pop();
				}
			}
		}
		System.out.println(sb);
	}
	
	static class Node{
		int height;
		int index;
		
		Node(int height, int index){
			this.height = height;
			this.index = index;
		}
	}
}