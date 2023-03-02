import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] list;
	static int n;
	static int m;
	static int r;
	static long[]v;
	static long[]arr;
	static long num=1;
	static void dfs(int r,int d) {
		v[r]=d;
		arr[r]=num++;
		for(int i=0;i<list[r].size();i++) {
			if(v[list[r].get(i)]==-1) {
				dfs(list[r].get(i),d+1);
				
			}
				
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		n =Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		list= new ArrayList[n+1];
		v=new long[n+1];
		arr=new long[n+1];
		for(int i=0;i<n+1;i++) {
			list[i]=new ArrayList<Integer>();
			v[i]=-1;
		}
		for(int i=0;i<m;i++) {
			str = br.readLine();
			st= new StringTokenizer(str," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}
		for(int i=1;i<=n;i++) {
			Collections.sort(list[i]);
		}
		dfs(r,0);
		long sum=0;
		for(int i=1;i<=n;i++) {
			sum+=v[i]*arr[i];
		}
		bw.write(String.valueOf(sum));

		bw.close();
		br.close();
	}
}