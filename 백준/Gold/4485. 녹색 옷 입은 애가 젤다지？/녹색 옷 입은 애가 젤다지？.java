import java.io.*;
import java.util.*;

public class Main {
	static int [][]arr;
	static int n;
	static int [] dr= {1,-1,0,0};
	static int [] dc= {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n=Integer.parseInt(br.readLine());
        int T=0;
        while(n!=0) {
        	T++;
        	arr=new int [n][n];
        	for(int i=0;i<n;i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		for(int j=0;j<n;j++) {
        			int tmp=Integer.parseInt(st.nextToken());
        			arr[i][j]=tmp;
        		}
        	}
        	
        	int answer=find();
        	bw.write("Problem "+T+": "+answer+"\n");
        	n=Integer.parseInt(br.readLine());
        }
        bw.close();
        br.close();
        
    }
    public static int find() {
    	int [][] dp = new int[n][n];
    	for(int i=0;i<n;i++) {
    		Arrays.fill(dp[i],2000);
    	}
    	Queue<Node> q= new LinkedList<>();
    	q.offer(new Node(0,0));
    	dp[0][0]=arr[0][0];
    	while(!q.isEmpty()) {
    		Node curr = q.poll();
    		for(int i=0;i<4;i++) {
    			int nr= curr.r+dr[i];
    			int nc= curr.c+dc[i];
    			if(nr<0||nr>=n||nc<0||nc>=n)
    				continue;
    			if(dp[nr][nc]>dp[curr.r][curr.c]+arr[nr][nc]) {
    				dp[nr][nc]=dp[curr.r][curr.c]+arr[nr][nc];
    				q.offer(new Node(nr,nc));
    			}
    		}
    	}
    	return dp[n-1][n-1];
    }
}


class Node{
	int r;
	int c;
	Node(int r,int c){
		this.r=r;
		this.c=c;
		
	}
}