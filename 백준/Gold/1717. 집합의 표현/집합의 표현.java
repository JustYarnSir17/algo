import java.util.*;
import java.io.*;

public class Main {
	static int [] parent ;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		parent = new int [n+1];
		for(int i=0;i<=n;i++) {
			parent[i]=i;
		}
		for(int i=0;i<m;i++) {
			st= new StringTokenizer(br.readLine());
			int cal= Integer.parseInt(st.nextToken());
			int a=Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			if(cal==0) {
				union(a,b);
			}
			else {
				if(findset(a)==findset(b)) {
					bw.write("YES");
					bw.newLine();
				}
				else {
					bw.write("NO");
					bw.newLine();
				}
			}
			
		}
		bw.close();
		br.close();
	}
	public static void union(int a, int b) {
		parent[findset(a)]=findset(b);
	}
	public static int findset(int a) {
		if(a!=parent[a]) {
			parent[a]=findset(parent[a]);
		}
		return parent[a];
	}
	
	
}