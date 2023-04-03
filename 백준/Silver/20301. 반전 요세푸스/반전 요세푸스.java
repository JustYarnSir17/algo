import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		Deque<Integer> dq = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			dq.add(i);
		}
		int idx=0;
		int cnt=0;
		boolean fl=false;
		while(!dq.isEmpty()) {
			if(!fl) {
				int tmp =dq.pollFirst();
				idx++;
				if(idx%k!=0) {
					dq.add(tmp);
				}
				else {
					bw.write(String.valueOf(tmp));
					bw.newLine();
					cnt++;
					if(cnt%m==0) {
						
						if(fl)
							fl=false;
						else fl=true;
						cnt=0;
					}
				}
			}
			else {
				int tmp=dq.pollLast();
				idx++;
				if(idx%k!=0) {
					dq.addFirst(tmp);
				}
				else {
					bw.write(String.valueOf(tmp));
					bw.newLine();
					cnt++;
					if(cnt%m==0) {
						if(fl)
							fl=false;
						else fl=true;
						cnt=0;
					}
				}
			}
			
		}
		
		bw.close();
		br.close();
	}
}