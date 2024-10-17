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
			int m =Integer.parseInt(st.nextToken());
			int cnt=0;
			for(int b=2;b<n;b++) {
				for(int a=1;a<b;a++) {
					double result = (double)((a*a)+(b*b)+m)/(a*b);
					if(result==Math.floor(result)) {
						cnt++;
					}
				}
			}
			bw.write(cnt+"\n");
			
		}
		bw.close();
		br.close();
	}
}