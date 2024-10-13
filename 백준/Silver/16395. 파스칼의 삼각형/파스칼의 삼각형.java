import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int [][] dp = new int [31][31];
        for(int i=1;i<=30;i++) {
        	dp[i][1]=1;
        	dp[i][i]=1;
        }
        
        for(int i=3;i<=30;i++) {
        	for(int j=2;j<i;j++) {
        		dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
        	}
        }
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        bw.write(dp[n][k]+"");
        bw.close();
        br.close();
	}	
	
}