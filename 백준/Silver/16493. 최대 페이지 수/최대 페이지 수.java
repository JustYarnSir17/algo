import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][] chapter =new int [m+1][2];
        int [][] dp = new int [m+1][n+1];
        
        for(int i=1;i<=m;i++) {
        	st = new StringTokenizer(br.readLine());
        	int days= Integer.parseInt(st.nextToken());
        	int pages= Integer.parseInt(st.nextToken());
        	chapter[i][0]=days;
        	chapter[i][1]=pages;
        }
        
        for(int i=1;i<=m;i++) {
        	for(int j=1;j<=n;j++) {
        		if(j-chapter[i][0]>=0) {
        			dp[i][j]=Math.max(dp[i-1][j-chapter[i][0]]+chapter[i][1],dp[i-1][j]);
        		}
        		else {
        			dp[i][j]=dp[i-1][j];
        		}
        	}
        }
        bw.write(dp[m][n]+"");
        bw.close();
        br.close();
	}
}