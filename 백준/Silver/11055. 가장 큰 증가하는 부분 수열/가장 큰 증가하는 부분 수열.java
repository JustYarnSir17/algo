import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n =Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr= new int [n];
        int answer=0;
        int [] dp=new int[n];
        
        for(int i=0;i<n;i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	arr[i]=tmp;
        }
        for(int i=0;i<n;i++) {
        	dp[i]=arr[i];
        	for(int j=0;j<i;j++) {
        		if(arr[i]>arr[j]) {
        			dp[i]=Math.max(dp[i],dp[j]+arr[i]);
        		}
        	}
        	answer=Math.max(answer,dp[i]);
        	
        }
        
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
        
	}
}