import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(in.readLine());
        
        Queue<Integer> queue = new ArrayDeque<>();
		
        for(int i = 1 ; i <= N ; i++) {
        	queue.add(i);
        }
        
        
        while(true) {
        	
        	if(queue.size() == 1) {
        		System.out.println(queue.poll());
        		System.exit(0);
        	}
        	
        	queue.poll();
        	queue.add(queue.poll());
        }
        
	}
}