import java.io.*;
import java.util.*;

import javax.net.ssl.HttpsURLConnection;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n =Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(new Comparator<Integer>() {
        	@Override
        	public int compare(Integer o1, Integer o2) {
        		return o2-o1;
        	}
        });
        
        for(int i=0;i<n;i++) {
        	int num=Integer.parseInt(br.readLine());
        	maxPq.offer(num);
        	minPq.offer(maxPq.poll());
        	if(minPq.size()>maxPq.size()) {
        		maxPq.offer(minPq.poll());
        		
        	}
        	
        	if(maxPq.size()>=minPq.size()) {
        		bw.write(maxPq.peek()+"\n");
        	}
        	else {
        		bw.write(minPq.peek()+"\n");
        	}
        	bw.flush();
        }
        bw.close();
        br.close();
        
        
        
        
	}
	
}