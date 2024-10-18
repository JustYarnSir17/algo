import java.io.*;
import java.util.*;


public class Main {
	static int n,m;
	static int [] arr;
	static long [] d;
	static List<List<Node>>list = new ArrayList<>();
	static int answer=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int [n];
        d=new long[n];
        Arrays.fill(d,Long.MAX_VALUE);
        d[0]=0;
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	list.add(new ArrayList<>());
        	int tmp =Integer.parseInt(st.nextToken());
        	arr[i]=tmp;
        }
        
        for(int i=0;i<m;i++) {
        	st=new StringTokenizer(br.readLine());
        	int a =Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int t = Integer.parseInt(st.nextToken());
        	
        	list.get(a).add(new Node(b,t));
        	list.get(b).add(new Node(a,t));
        }
        find();
//        for(int i=0;i<n;i++) {
//        	System.out.println(d[i]);
//        }
        if(d[n-1]==Long.MAX_VALUE) {
        	bw.write("-1");
        }
        else {
        	
        	bw.write(d[n-1]+"");
        }
        bw.close();
        br.close();
	}
	public static void find() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0,0));
		while(!pq.isEmpty()) {
			Node curr= pq.poll();
			if(d[curr.next]<curr.dist) {
				continue;
			}
			for(int i=0;i<list.get(curr.next).size();i++) {
				int next = list.get(curr.next).get(i).next;
				long dist = list.get(curr.next).get(i).dist;
				if(d[next]>curr.dist+dist) {
					if(arr[next]!=1) {
						d[next]=curr.dist+dist;
						pq.offer(new Node(next,curr.dist+dist));
					}
					else if(arr[next]==1&&next==n-1) {
						d[next]=curr.dist+dist;
					}
				}
			}
			
			
		}
		
	}
}

class Node implements Comparable<Node>{
	int next;
	long dist;
	Node(int next, long dist) {
		this.next=next;
		this.dist=dist;
	}
	@Override
	public int compareTo(Node o) {
		if(this.dist<o.dist) {
			return-1;
		}
		else {
			return 1;
		}
	}
}