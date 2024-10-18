import java.io.*;
import java.util.*;


public class Main {
	static int n;
	static int answer=0;
	static List<List<Node>> list = new ArrayList<>();
	static boolean[]v;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(br.readLine());
        v=new boolean[n+1];
        for(int i=0;i<=n;i++) {
        	list.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++) {
        	StringTokenizer st= new StringTokenizer(br.readLine());
        	int a =Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int dist= Integer.parseInt(st.nextToken());
        	list.get(a).add(new Node(b,dist));
        	list.get(b).add(new Node(a,dist));        	
        }
        
        for(int i=1;i<=n;i++) {
        	v[i]=true;
        	find(i,0);
        	v[i]=false;
        }
        
        bw.write(answer+"");
        bw.close();
        br.close();
	}
	public static void find(int idx,int cnt) {
		
		boolean tr=false;
		for(int i=0;i<list.get(idx).size();i++) {
			int next= list.get(idx).get(i).next;
			int dist= list.get(idx).get(i).dist;
			if(!v[next]) {
				tr=true;
				v[idx]=true;
				find(next,cnt+dist);
				v[idx]=false;
			}
		}
		if(!tr) {
			answer=Math.max(cnt,answer);
		}
		
	}
	
	
//	public static void find(int idx) {
//		boolean[] v= new boolean[n+1];
//		Queue<Node> q= new LinkedList<>();
//		v[idx]=true;
//		q.offer(new Node(idx,0));
//		while(!q.isEmpty()) {
//			Node curr= q.poll();
//			answer=Math.max(answer,curr.dist);
//			for(int i=0;i<list.get(curr.next).size();i++) {
//				int next= list.get(curr.next).get(i).next;
//				int dist= list.get(curr.next).get(i).dist;
//				if(!v[next]) {
//					q.offer(new Node(next,curr.dist+dist));
//					v[next]=true;
//				}
//				
//			}
//		}
//	}
}

class Node{
	int next;
	int dist;
	Node(int next, int dist){
		this.next=next;
		this.dist=dist;
	}
}