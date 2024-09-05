import java.io.*;
import java.util.*;


public class Main {
	static int n,m,k;
	static int[][] arr;
	static int [] dr = {1,-1,0,0};
	static int [] dc = {0,0,1,-1};
	static boolean[][]v;
	
	static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        
        arr= new int [n][m];
        v= new boolean[n][m];
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<m;j++) {
        		int tmp =Integer.parseInt(st.nextToken());
        		arr[i][j]=tmp;
        	}
        }
        k=Integer.parseInt(br.readLine());
        find();
        bw.write(sb.toString());
        bw.close();
        br.close();
	}
	
	public static void find() {
		PriorityQueue<Node> pq =new PriorityQueue<>();
		for(int i=0;i<n;i++) {
			if(!v[i][0]) {
				pq.offer(new Node(i,0,arr[i][0]));
				v[i][0]=true;
			}
			if(!v[i][m-1]) {
				pq.offer(new Node(i,m-1,arr[i][m-1]));
				v[i][m-1]=true;
			}
			
		}
		for(int i=0;i<m;i++) {
			if(!v[0][i]) {
				pq.offer(new Node(0,i,arr[0][i]));
				v[0][i]=true;
			}
			if(!v[n-1][i]) {
				pq.offer(new Node(n-1,i,arr[n-1][i]));
				v[n-1][i]=true;
			}
		}
		int cnt=0;
		while(cnt<k) {
			Node tmp = pq.poll();
			cnt++;
			sb.append((tmp.r+1)+" "+(tmp.c+1)+"\n");
			for(int i=0;i<4;i++) {
				int nr = tmp.r+dr[i];
				int nc = tmp.c+dc[i];
				if(nr<0||nr>=n||nc<0||nc>=m)
					continue;
				if(!v[nr][nc]) {
					v[nr][nc]=true;
					pq.offer(new Node(nr,nc,arr[nr][nc]));
				}
					
			}
		}
		
		
		
	}
}

class Node implements Comparable<Node>{
	int r;
	int c;
	int val;
	Node(int r, int c, int val){
		this.r=r;
		this.c=c;
		this.val=val;
	}
	@Override
	public int compareTo(Node o) {
		return o.val-this.val;
	}
}