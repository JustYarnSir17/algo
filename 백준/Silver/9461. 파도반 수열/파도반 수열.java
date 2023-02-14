import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		long [] dp = new long [101];
		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		dp[4]=2;
		dp[5]=2;
		for(int i=6;i<=100;i++) {
			dp[i]=dp[i-5]+dp[i-1];
		}
		for(int i=0;i<n;i++) {
			int m=Integer.parseInt(br.readLine());
			bw.write(String.valueOf(dp[m]));
			bw.newLine();
		}
		
		br.close();
		bw.close();
	}
}