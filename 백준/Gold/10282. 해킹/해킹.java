import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int d;
	static int c;
	static List<List<Node>>list;
	static int []t;
	static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T= Integer.parseInt(br.readLine());
        for(int time=0;time<T;time++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	n=Integer.parseInt(st.nextToken());
        	d=Integer.parseInt(st.nextToken());
        	c=Integer.parseInt(st.nextToken());
        	list = new ArrayList<>();
        	for(int i=0;i<n;i++) {
        		list.add(new ArrayList<>());
        	}
        	t= new int[n];
        	v= new boolean[n];
        	Arrays.fill(t,Integer.MAX_VALUE);
        	for(int i=0;i<d;i++) {
        		st=new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken())-1;
        		int b = Integer.parseInt(st.nextToken())-1;
        		int s = Integer.parseInt(st.nextToken());
        		list.get(b).add(new Node(a,s));
        	}
        	dijkstra(c-1);
        	int count=0;
        	int sec=0;
        	for(int i=0;i<n;i++) {
        		if(t[i]!=Integer.MAX_VALUE) {
        			++count;
        			sec=Math.max(t[i],sec);
        		}
        	}
        	bw.write(count+" "+sec+"\n");
        }
        bw.close();
        br.close();
        
    }
    public static void dijkstra(int start) {
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	t[start]=0;
    	pq.offer(new Node(start,0));
    	while(!pq.isEmpty()) {
    		Node node= pq.poll();
    		int curr= node.idx;
    		if(v[curr])
    			continue;
    		v[curr]=true;
    		for(Node n:list.get(curr)) {
    			if(!v[n.idx]&&t[curr]+n.s<t[n.idx]) {
    				t[n.idx]=t[curr]+n.s;
    				pq.offer(new Node(n.idx,t[n.idx]));
    			}
    		}
    	}
    	
    }
}

class Node implements Comparable<Node>{
	int idx;
	int s;
	Node(int idx,int s){
		this.idx=idx;
		this.s=s;
	}
	@Override
	public int compareTo(Node other) {
		return Integer.compare(this.s,other.s);
	}
}