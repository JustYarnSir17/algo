import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Long> pq = new PriorityQueue<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		for(int i=0;i<m;i++) {
			long tmp1 = pq.poll();
			long tmp2= pq.poll();
			long sum=tmp1+tmp2;
			pq.add(sum);
			pq.add(sum);
		}
		long sum=0;
		for(int i=0;i<n;i++) {
			sum+=pq.poll();
		}
		bw.write(String.valueOf(sum));
		bw.close();
		br.close();
	}
}