import java.io.*;
import java.util.*;

public class Main {
	static Deque<Integer> dq = new ArrayDeque<Integer>();
	static Queue<Integer> q = new LinkedList<>();
	static int cnt=0;
	static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n =Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        
        for(int i=1;i<=n;i++) {
        	dq.offer(i);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
        	int tmp =Integer.parseInt(st.nextToken());
        	q.offer(tmp);
        }
        while(!q.isEmpty()) {
        	find();
        }
        bw.write(cnt+"");
        bw.close();
        br.close();
	}
    
    public static void find() {
    	if(q.peek()==dq.peek()) {
    		dq.poll();
    		q.poll();
    	}
    	else {
    		int cnt1=-1;
    		int cnt2=0;
    		Iterator<Integer> iterator = dq.iterator();
    		Iterator<Integer> descIterator= dq.descendingIterator();
    		while(iterator.hasNext()) {
    			Integer value=iterator.next();
    			cnt1++;
    			if(value==q.peek()) {
    				break;
    			}
    		}
    		while(descIterator.hasNext()) {
    			Integer value=descIterator.next();
    			cnt2++;
    			if(value==q.peek()) {
    				break;
    			};
    			
    		}
    		if(cnt1<cnt2) {
    			while(q.peek()!=dq.peek()) {
    				int tmp = dq.pollFirst();
    				dq.offerLast(tmp);
    			}
    			cnt+=cnt1;
    		}
    		else {
    			while(q.peek()!=dq.peek()) {
    				int tmp = dq.pollLast();
    				dq.offerFirst(tmp);
    			
    			}
    			cnt+=cnt2;
    		}
    		
    	}
    }
	
}