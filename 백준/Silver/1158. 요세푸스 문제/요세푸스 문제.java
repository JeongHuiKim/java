import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        for(int i = 1 ; i <= N ; i++ ) {
        	queue.offer(i);
        }
        
        int cnt = 1;
        while(queue.size()!= 1) {
        	if(cnt == K) {
        		cnt = 1;
        		sb.append(queue.poll()+", ");
        	}
        	else {
        		queue.offer(queue.poll());
            	cnt++;
        	}
        }
        
        sb.append(queue.poll() + ">");
        
        System.out.println(sb);
        
	}
}