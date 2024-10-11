import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        	@Override
        	public int compare(Integer o1, Integer o2) {
        		return o2-o1;
        	}
        });
        
        int n =Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
        	int tmp = Integer.parseInt(br.readLine());
        	pq.offer(tmp);
        }
        
        while(!pq.isEmpty()) {
        	bw.write(pq.poll()+"\n");
        }
        bw.close();
        br.close();
	}
	
}