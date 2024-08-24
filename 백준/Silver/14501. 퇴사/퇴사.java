import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int [][] arr= new int [n][2];
        for(int i=0;i<n;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int t= Integer.parseInt(st.nextToken());
        	int p= Integer.parseInt(st.nextToken());
        	arr[i][0]=t;
        	arr[i][1]=p;
        }
        int [] dp = new int [n+1];
        
        for(int i=n-1;i>=0;i--) {
        	if(i+arr[i][0]<=n) {
        		dp[i]=Math.max(dp[i+1],arr[i][1]+dp[i+arr[i][0]]);
        	}
        	else {
        		dp[i]=dp[i+1];
        	}
        }
        
        bw.write(dp[0]+"");
        bw.close();
        br.close();
    }
    
    
}