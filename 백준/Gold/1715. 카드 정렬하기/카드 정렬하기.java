import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n =Integer.parseInt(br.readLine());
		int answer=0;
		for(int i=0;i<n;i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		while(n>1) {
			int tmp1=pq.poll();
			int tmp2=pq.poll();
			int sum=tmp1+tmp2;
			answer+=sum;
			pq.add(sum);
			--n;
		}
		bw.write(String.valueOf(answer));
		bw.close();
		br.close();
	}
}