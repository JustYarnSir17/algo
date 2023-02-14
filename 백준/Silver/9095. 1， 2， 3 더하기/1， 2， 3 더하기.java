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
		int [] dp = new int [11];
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		for(int i=4;i<=10;i++) {
			dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
		}
		for(int i=0;i<n;i++) {
			int k= Integer.parseInt(br.readLine());
			bw.write(String.valueOf(dp[k]));
			bw.newLine();
		}
		
		
		br.close();
		bw.close();
	}
}