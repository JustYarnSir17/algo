import java.util.*;
import java.io.*;

public class Main {
	static int [] city ;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		city = new int [n+1];
		for(int i=1;i<=n;i++) {
			city[i]=i;
		}
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx=1;
			while(st.hasMoreElements()) {
				int tmp = Integer.parseInt(st.nextToken());
				if(idx==i) {
					++idx;
					continue;
				}
				if(tmp==1) {
					union(i,idx);
				}
				++idx;
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean tr= true;
		int start = Integer.parseInt(st.nextToken());
		
		while(st.hasMoreElements()) {
			int to = Integer.parseInt(st.nextToken());
			if(findset(start)!=findset(to)) {
				tr=false;
				break;
			}
			start=to;
		}
		if(tr) {
			bw.write("YES");
		}
		else {
			bw.write("NO");
		}
		bw.close();
		br.close();
	}
	public static void union(int a,int b) {
		city[findset(a)]=findset(b);
	}
	public static int findset(int a) {
		if(a==city[a])return city[a];
		city[a]=findset(city[a]);
		return city[a];
	}
	
}