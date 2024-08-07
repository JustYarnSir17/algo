import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n=Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());
        int [] arr = new int[n];
        int [] dp = new int [k+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        
        for(int i=0;i<n;i++) {
        	int tmp =Integer.parseInt(br.readLine());
        	arr[i]=tmp;
        }
        Arrays.sort(arr);
        for(int i=1;i<=k;i++) {//k까지의 가치
        	for(int j=0;j<n;j++) {//주어진 동전 순회
        		if(arr[j]<i) {//만약 주어진 가치가 해당 동전의 가치보다 크다면
        			if(dp[i-arr[j]]!=-1) {//만약 해당 동전을 뺀 가치를 만들 수 있다면
        				if(dp[i]!=-1) {
        					dp[i]=Math.min(dp[i-arr[j]]+1,dp[i]);
        				}
        				else {
        					dp[i]=dp[i-arr[j]]+1;
        				}
        			}
        		}
        		else if(i-arr[j]==0) {//동전의 가치가 해당 가치와 같다면
        			dp[i]=1;//1개면 ok
        		}
        	}
        }
        bw.write(dp[k]+"");
        bw.close();
        br.close();
    }
}