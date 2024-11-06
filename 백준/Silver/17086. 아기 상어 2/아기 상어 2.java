import java.io.*;
import java.util.*;


public class Main {
	static int n,m;
	static int [][]arr;
	static Queue<Node> q = new LinkedList<>();
	static int[][] v;
	static int [] dr = {-1,-1,-1,0,0,1,1,1};
	static int [] dc = {-1,0,1,-1,1,-1,0,1};
	static int value=0;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n=Integer.parseInt(st.nextToken());
    	m=Integer.parseInt(st.nextToken());
    	
    	arr=new int[n][m];
    	v=new int[n][m];
    	
    	for(int i=0;i<n;i++) {
    		Arrays.fill(v[i],Integer.MAX_VALUE);
    		st=new StringTokenizer(br.readLine());
    		for(int j=0;j<m;j++) {
    			arr[i][j]=Integer.parseInt(st.nextToken());
    			if(arr[i][j]==1) {
    				q.offer(new Node(i,j));
    			}
    		}
    	}
    	find();
    	bw.write(String.valueOf(value));
    	bw.close();
    	br.close();
    	
    }
    
    public static void find() {
    	for(Node curr:q) {
    		v[curr.r][curr.c]=0;
    	}
    	
    	while(!q.isEmpty()) {
    		Node curr = q.poll();
    		for(int i=0;i<8;i++) {
    			int nr = curr.r+dr[i];
    			int nc = curr.c+dc[i];
    			if(nr<0||nr>=n||nc<0||nc>=m)
    				continue;
    			if(v[nr][nc]>v[curr.r][curr.c]+1&&arr[nr][nc]==0) {
    				v[nr][nc]=v[curr.r][curr.c]+1;
    				q.offer(new Node(nr,nc));
    			}
    		}
    	}
    	
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			value=Math.max(value,v[i][j]);
    		}
    			
    	}
    }
    
    
}

class Node{
	int r;
	int c;
	Node(int r, int c){
		this.r=r;
		this.c=c;
	}
}