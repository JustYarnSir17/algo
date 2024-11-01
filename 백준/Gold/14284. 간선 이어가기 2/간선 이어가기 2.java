import java.io.*;
import java.util.*;


public class Main {
	static int n,m,s,t;
	static List<List<Node>> list =new ArrayList<>();
	static String [] str;
	static int [] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st= new StringTokenizer(br.readLine());
        
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        d= new int [n+1];
        Arrays.fill(d,Integer.MAX_VALUE);
        for(int i=0;i<=n;i++) {
        	list.add(new ArrayList<>());
        	
        }
        str = new String[m];
        for(int i=0;i<m;i++) {
        	st = new StringTokenizer(br.readLine());
    		int a= Integer.parseInt(st.nextToken());
    		int b= Integer.parseInt(st.nextToken());
    		int c= Integer.parseInt(st.nextToken());
    		list.get(a).add(new Node(b,c));
    		list.get(b).add(new Node(a,c));
        }
        st=new StringTokenizer(br.readLine());
        s=Integer.parseInt(st.nextToken());
        d[s]=0;
        t=Integer.parseInt(st.nextToken());
        search();
        bw.write(d[t]+"");
        bw.close();
        br.close();
    }
    
    static public void search() {
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.offer(new Node(s,0));
    	while(!pq.isEmpty()) {
    		Node curr = pq.poll();
    		
    		for(int i=0;i<list.get(curr.next).size();i++) {
    			int next = list.get(curr.next).get(i).next;
    			int dist = list.get(curr.next).get(i).dist;
    			if(d[next]>=curr.dist+dist) {
    				d[next]=curr.dist+dist;
    				pq.offer(new Node(next,curr.dist+dist));
    			}
    		}
    	}
    	
    	
    	
    	
    }
    
    
}
class Node implements Comparable<Node>{
	int next;
	int dist;
	Node(int next, int dist){
		this.next=next;
		this.dist=dist;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.dist-o.dist;
	}
}