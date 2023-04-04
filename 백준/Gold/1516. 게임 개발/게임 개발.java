import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static LinkedList<Node>list[];
	static int [] arr;
	static int []time;
	static int [] cost;
	static final int MAX=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n=Integer.parseInt(br.readLine());
		list=new LinkedList[n+1];
		arr= new int[n+1];
		time=new int [n+1];
		cost=new int [n+1];
		for(int i=0;i<=n;i++) {
			list[i]=new LinkedList<>();
		}
		for(int i=1;i<=n;i++) {
			
			StringTokenizer st= new StringTokenizer(br.readLine());
			int W=Integer.parseInt(st.nextToken());
			cost[i]=W;
			while(st.hasMoreTokens()) {
				int x=Integer.parseInt(st.nextToken());
				if(x!=-1) {
					list[x].add(new Node(i,W));
					arr[i]++;
				}
				else
					break;
			}
		}
		Queue<Integer>q= new LinkedList<>();
		for(int i=1;i<=n;i++) {
			if(arr[i]==0) {
				q.add(i);
				time[i]=cost[i];
			}
		}
		
		while(!q.isEmpty()) {
			int tmp=q.poll();
			arr[tmp]--;
			for(Node n:list[tmp]) {
				arr[n.v]--;
				time[n.v]=Math.max(time[tmp]+cost[n.v], time[n.v]);
				if(arr[n.v]==0) {
					
					q.add(n.v);
				}
				
			}
		}
		for(int i=1;i<=n;i++) {
			bw.write(time[i]+"\n");
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