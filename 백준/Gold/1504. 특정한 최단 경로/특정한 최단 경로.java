import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main {
	static int n;
	static int e;
	static LinkedList<Node>[]list;
	static int [] dist;
	static int [] dist1;
	static int [] dist2;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n =Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		list=new LinkedList[n+1];
		for(int i=0;i<=n;i++) {
			list[i]=new LinkedList<>();
		}
		dist = new int [n+1];
		dist1 = new int [n+1];
		dist2 = new int [n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(dist1, Integer.MAX_VALUE);
		Arrays.fill(dist2, Integer.MAX_VALUE);
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			list[a].add(new Node(b,d));
			list[b].add(new Node(a,d));
		}
		st= new StringTokenizer(br.readLine());
		int u=Integer.parseInt(st.nextToken());
		int v=Integer.parseInt(st.nextToken());
		if(e>0) {
		dijkstra(1,dist);
		dijkstra(u,dist1);
		dijkstra(v,dist2);
		int sum=0;
		if(dist[u]!=Integer.MAX_VALUE&&dist2[n]!=Integer.MAX_VALUE)
			sum+=dist[u]+dist1[v]+dist2[n];
		if(dist[v]!=Integer.MAX_VALUE&&dist1[n]!=Integer.MAX_VALUE)
			sum=Math.min(sum, dist[v]+dist2[u]+dist1[n]);
		if(sum!=0)
			bw.write(String.valueOf(sum));
		else
			bw.write("-1");
		}
		else {
			bw.write("-1");
		}
		bw.close();
		br.close();
		
	}
	private static void dijkstra(int st,int []dist) {
		// TODO Auto-generated method stub
		boolean[] v= new boolean[n+1];
		dist[st]=0;
		for(int i=0;i<n-1;i++) {
			int min=Integer.MAX_VALUE;
			int idx=-1;
			for(int j=1;j<=n;j++) {
				if(!v[j]&&min>dist[j]) {
					min=dist[j];
					idx=j;
				}
			}
			
			v[idx]=true;
			if(idx==-1)break;
			for(int j=0;j<list[idx].size();j++) {
				Node cur= list[idx].get(j);
				if(!v[cur.v]&&dist[cur.v]>dist[idx]+cur.d) {
					dist[cur.v]=dist[idx]+cur.d;
				}
			}
		}
		
	}
}
class Node{
	int v;
	int d;
	Node(int v,int d){
		this.v=v;
		this.d=d;
	}
}