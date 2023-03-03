import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<Integer>[] list;
	static boolean[] vi;
	static void dfs(int r) throws IOException{
		bw.write(r+" ");
		vi[r]=true;
		for(int i=0;i<list[r].size();i++) {
			if(vi[list[r].get(i)]!=true) {
				dfs(list[r].get(i));
			}
		}
	}
	static void bfs(int r) throws IOException{
		vi[r]=true;
		Queue<Integer> q= new LinkedList<>();
		q.offer(r);
		while(!q.isEmpty()) {
			int tmp= q.poll();
			bw.write(tmp+" ");
			for(int i=0;i<list[tmp].size();i++) {
				if(vi[list[tmp].get(i)]!=true) {
					vi[list[tmp].get(i)]=true;
					q.add(list[tmp].get(i));
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		String str= br.readLine();
		StringTokenizer st = new StringTokenizer (str," ");
		int n =Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v= Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		vi= new boolean [n+1];
		for(int i=0;i<=n;i++) {
			list[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			str= br.readLine();
			st = new StringTokenizer(str, " ");
			int x= Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}
		for(int i=1;i<=n;i++) {
			Collections.sort(list[i]);
		}
		dfs(v);
		Arrays.fill(vi, false);
		bw.flush();
		bw.newLine();
		bfs(v);
		bw.close();
		br.close();
	}
}