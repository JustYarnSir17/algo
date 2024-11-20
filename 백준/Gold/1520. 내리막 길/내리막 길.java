import java.io.*;
import java.util.*;


public class Main {
	static int n,m;
	static int [][]arr;
	static int [][] dp;
	static int [] dr= {1,0,-1,0};
	static int [] dc = {0,1,0,-1};
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n=Integer.parseInt(st.nextToken());
    	m=Integer.parseInt(st.nextToken());
    	arr = new int [n][m];
    	dp = new int [n][m];
    	for(int i=0;i<n;i++) {
    		st=new StringTokenizer(br.readLine());
    		Arrays.fill(dp[i],-1);
    		for(int j=0;j<m;j++) {
    			arr[i][j]=Integer.parseInt(st.nextToken());
    		}
    	}
    	int cnt=find(0,0);
    	bw.write(String.valueOf(cnt));
    	bw.close();
    	br.close();
	}
    
    public static int find(int r, int c) {
    	if(r==n-1&&c==m-1) {
    		return 1;
    	}
    	
    	if(dp[r][c]!=-1) {
    		return dp[r][c];
    	}
    	
    	dp[r][c]=0;
    	
    	for(int i=0;i<4;i++) {
    		int nr=r+dr[i];
    		int nc=c+dc[i];
    		
    		if(nr>=0&&nr<n&&nc>=0&&nc<m&&arr[nr][nc]<arr[r][c]) {
    			dp[r][c]+=find(nr,nc);
    		}
    	}
    	return dp[r][c];
    	
    }
}