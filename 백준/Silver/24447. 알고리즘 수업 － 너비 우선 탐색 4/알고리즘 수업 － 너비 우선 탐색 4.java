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
	static long[]v;
	static long[]arr;
	static int count=1;
	static int num=0;
	static void bfs(int r) {
		
		Queue<Pair> q= new LinkedList<>();
		q.add(new Pair(r,0));
		v[r]=num++;
		arr[r]=count++;
		while(!q.isEmpty()) {
			
			Pair tmp=q.poll();
			
			for(int i=0;i<list[tmp.r].size();i++) {
				if(v[list[tmp.r].get(i)]==-1) {
					if(arr[list[tmp.r].get(i)]==0) {
						arr[list[tmp.r].get(i)]=count++;
					}
					v[list[tmp.r].get(i)]=tmp.cnt+1;
					q.add(new Pair(list[tmp.r].get(i),tmp.cnt+1));
				}
			}
			num++;
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
		arr=new long[n+1];
		v=new  long[n+1];
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
		bfs(r);
		long sum=0;
		for(int i=1;i<=n;i++) {
			sum+=v[i]*arr[i];
		}

		bw.write(String.valueOf(sum));

		bw.close();
		br.close();
	}
}

class Pair{
	int r;
	int cnt;
	Pair(int r,int cnt){
		this.r=r;
		this.cnt=cnt;
	}
}