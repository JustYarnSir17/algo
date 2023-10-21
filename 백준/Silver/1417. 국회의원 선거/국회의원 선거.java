import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int n =Integer.parseInt(br.readLine());
		int answer =0;
		int me=0;
		if(n==1) {
			me=Integer.parseInt(br.readLine());
			answer= 0;
		}
		else {
		for(int i=0;i<n;i++) {
				if(i==0) {
					me=Integer.parseInt(br.readLine());
				}
				else {
					pq.add(Integer.parseInt(br.readLine()));
				}
			}	
		while(pq.peek()>=me) {
			int tmp = pq.poll();
			--tmp;
			++me;
			pq.add(tmp);
			++answer;
		}
		}
		
		bw.write(String.valueOf(answer));
		bw.close();
		br.close();
	}
}