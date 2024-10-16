import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t =Integer.parseInt(br.readLine());
		for(int time=0;time<t;time++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n =Integer.parseInt(st.nextToken());
			int k =Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			int cnt=0;
			for(int i=0;i<n;i++) {
				int tmp = Integer.parseInt(st.nextToken());
				cnt+=tmp/k;
			}
			
			bw.write(cnt+"\n");
			
			
			
		}
		bw.close();
		br.close();
	}
}