import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[1001];
        dp[1]=BigInteger.ZERO;
        dp[2]=BigInteger.ONE;
        dp[3]=BigInteger.ONE;
        for(int i=4;i<=1000;i++) {
        	if(i%2==0)
        		dp[i]=dp[i-1].add(dp[i-1]).add(BigInteger.ONE);
        	else
        		dp[i]=dp[i-1].add(dp[i-1]).subtract(BigInteger.ONE);
        }
        System.out.println(dp[n]);
        
    }
    
    
}