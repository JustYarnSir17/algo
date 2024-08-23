import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] arr= new int [n];
        int []dp = new int [k+1];
        for(int i=0;i<n;i++) {
        	int tmp =Integer.parseInt(br.readLine());
        	arr[i]=tmp;
        }
        dp[0]=1;
        
        Arrays.sort(arr);
        for(int i=0;i<n;i++) {
        	for(int j=1;j<=k;j++) {
        		if(j-arr[i]>=0) {
        			dp[j]+=dp[j-arr[i]];
        		}
        	}
        }
        bw.write(dp[k]+"");
        bw.close();
        br.close();
    }
}