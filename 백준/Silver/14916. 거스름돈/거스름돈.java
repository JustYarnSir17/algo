import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n =Integer.parseInt(br.readLine());
        int [] dp= new int [100001];
        Arrays.fill(dp,-1);
        dp[2]=1;
        dp[5]=1;
        dp[4]=2;
        for(int i=6;i<=100000;i++) {
        	if(dp[i-2]!=-1) {
        		if(dp[i-5]!=-1) {
        			dp[i]=Math.min(dp[i-2]+1,dp[i-5]+1);
        		}
        		else {
        			dp[i]=dp[i-2]+1;
        		}
        	}
        	else {
        		if(dp[i-5]!=-1) {
        			dp[i]=dp[i-5]+1;
        		}
        		
        	}
        }
        bw.write(dp[n]+"");
        
        bw.close();
        br.close();
	}
	
}