import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] list;
	static int n;
	static int m;
	static int r;
	static boolean[]v;
	static int[]arr;
	static int num=1;
	static void bfs(int r) {
		
		Queue<Integer> q= new LinkedList<>();
		q.add(r);
		arr[r]=num++;
		v[r]=true;
		while(!q.isEmpty()) {
			
			int tmp=q.poll();
			for(int i=list[tmp].size()-1;i>=0;i--) {
				if(v[list[tmp].get(i)]!=true) {
					v[list[tmp].get(i)]=true;
					arr[list[tmp].get(i)]=num++;
					q.add(list[tmp].get(i));
				}
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
		v=new boolean[n+1];
		arr=new int[n+1];
		for(int i=0;i<n+1;i++) {
			list[i]=new ArrayList<Integer>();
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
		bfs(r);
		for(int i=1;i<=n;i++) {
			bw.write(String.valueOf(arr[i]));
			bw.newLine();
		}


		bw.close();
		br.close();
	}
}