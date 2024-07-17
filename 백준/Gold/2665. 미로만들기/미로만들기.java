import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 100000;
	static int [][] arr;
	static boolean [][]v;
	static int n;
	static int [] dr= {1,-1,0,0};
	static int [] dc= {0,0,1,-1};
	
	static class Node{
		int r;
		int c;
		int cost;
		Node(int r,int c,int cost){
			this.r=r;
			this.c=c;
			this.cost=cost;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        
        n= Integer.parseInt(br.readLine());
        arr= new int [n][n];
        v=new boolean[n][n];
        
        for(int i=0;i<n;i++) {
        	String tmp = br.readLine();
        	for(int j=0;j<n;j++) {
        		arr[i][j]=tmp.charAt(j)-'0';
        	}
        }
        int answer= find();
        
        bw.write(answer+"");
        bw.close();
        br.close();
        
    }
    
    public static int find() {
    	Deque<Node> dq = new ArrayDeque<>();
    	
    	dq.add(new Node(0,0,0));
    	v[0][0]=true;
    	while(!dq.isEmpty()) {
    		Node curr = dq.poll();
    		if(curr.r==n-1&&curr.c==n-1) {
    			return curr.cost;
    		}
    		for(int i=0;i<4;i++) {
    			int nr= curr.r+dr[i];
    			int nc= curr.c+dc[i];
    			if(nr<0||nr>=n||nc<0||nc>=n) {
    				continue;
    			}
    			
    			if(arr[nr][nc]==1&&!v[nr][nc]) {
    				dq.addFirst(new Node(nr,nc,curr.cost));
    				v[nr][nc]=true;
    			}
    			else if(arr[nr][nc]==0&&!v[nr][nc]) {
    				dq.addLast(new Node(nr,nc,curr.cost+1));
    				v[nr][nc]=true;
    			}
    		}
    		
    		
    	}
    	return -1;
    	
    }
}