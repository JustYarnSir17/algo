import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}
		int answer=0;
		for(int i=0;i<n;i++) {
			answer=pq.poll();
		}
		bw.write(String.valueOf(answer));
		bw.close();
		br.close();
	}
}