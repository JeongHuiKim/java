import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		ArrayList<Node>[] graph = new ArrayList[V+1];
		for(int i = 1 ; i <= V ; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		int start = Integer.parseInt(in.readLine());
		
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(in.readLine());
			graph[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		final int INF = Integer.MAX_VALUE;
		
		boolean[] isSelected = new boolean[V+1];
		int[] distance = new int[V+1];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		for(int k = 0 ; k < V ; k++){
			
			// 방문하지 않았으면서 가장 작은 Idx 찾기
			int minIdx = 0;
			int min = INF;
			for(int i = 1 ; i <= V ; i++) {
				if(min > distance[i] && !isSelected[i]) {
					minIdx = i;
					min = distance[i];
				}
			}
			
			if(min == INF) break;
			
			isSelected[minIdx] = true;
			
			for(int i = 0 ; i < graph[minIdx].size() ; i++) {
				Node currNode = graph[minIdx].get(i);
				if(!isSelected[currNode.to] && distance[currNode.to] > distance[minIdx] + currNode.weight) {
					distance[currNode.to] = distance[minIdx] + currNode.weight;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i <= V ; i++) {
			sb.append(distance[i] == INF ? "INF" : distance[i]).append("\n");
		}
		System.out.print(sb);
	}
	
	static class Node{
		int to;
		int weight;
		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
}