import java.util.*;
import java.io.*;

public class Main {
	
	static int n;
	static int m;
	static List<List<Node>>  list = new ArrayList<>();
	static int [] d;
	static boolean[] v;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		for(int i=0;i<n;i++) {
			list.add(new ArrayList<>());
			
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int cost= Integer.parseInt(st.nextToken());
			list.get(from).add(new Node(to,cost));
			list.get(to).add(new Node(from, cost));
		}
		dijkstra(0);
		bw.write(d[n-1]+"");
		bw.close();
		br.close();
		
	}
	public static void dijkstra(int x) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		d=new int[n];
		v=new boolean[n];
		
		Arrays.fill(d,Integer.MAX_VALUE);
		d[x]=0;
		pq.add(new Node(x,0));
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int curr= node.index;
			
			if(v[curr])
				continue;
			v[curr]=true;
			
			for(Node n : list.get(curr)) {
				if(!v[n.index]&&d[curr]+n.cost<d[n.index]) {
					d[n.index]= d[curr]+n.cost;
					pq.add(new Node(n.index,d[n.index]));
				}
			}
		}
	}
}
class Node implements Comparable<Node>{
	int index;
	int cost;
	
	Node(int index,int cost){
		this.index=index;
		this.cost=cost;
	}
	
	@Override
	public int compareTo(Node other) {
		return Integer.compare(this.cost,other.cost);
	}
}