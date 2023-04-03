import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int []arr;
	static int []order;
	static int [] dp;
	static LinkedList<Node>[] list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			k=Integer.parseInt(st.nextToken());
			arr=new int [n+1];
			order=new int [n+1];
			list=new LinkedList[n+1];
			dp=new int [n+1];
			for(int i=0;i<n+1;i++) {
				list[i]=new LinkedList<>();
			}
			st=new StringTokenizer(br.readLine());
			for(int i=1;i<=n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<k;i++) {
				st=new StringTokenizer(br.readLine());
				int a= Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				list[a].add(new Node(b,arr[b]));
				order[b]++;
			}
			int w=Integer.parseInt(br.readLine());
			Queue<Integer> q = new LinkedList<>();
			for(int i=1;i<=n;i++) {
				if(order[i]==0) {
					q.add(i);
					dp[i]=arr[i];
				}
				
			}
			while(!q.isEmpty()) {
				int tmp=q.poll();
				order[tmp]--;
				for(Node n:list[tmp]) {
					order[n.v]--;

					if(dp[n.v]<dp[tmp]+arr[n.v])
						dp[n.v]=dp[tmp]+arr[n.v];
					if(order[n.v]==0) {
						q.add(n.v);
					
					}
				}
			}
			bw.write(String.valueOf(dp[w]));
			bw.newLine();
		}

		bw.close();
		br.close();
		
	}
	
}
class Node{
	int v;
	int w;
	Node(int v,int w){
		this.v=v;
		this.w=w;
	}
}