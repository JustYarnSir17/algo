import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static Integer []dp;
	static int []arr;
	public static int Dp (int n) {
		if(dp[n]==null) {
			dp[n]=Math.max(Dp(n-2), Dp(n-3)+arr[n-1])+arr[n];
		}
		return dp[n];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		dp= new Integer [n+1];
		arr= new int [n+1];
		
		for(int i=1;i<=n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		dp[0]=arr[0];
		dp[1]=arr[1];
		if(n>=2) {
			dp[2]=arr[1]+arr[2];
		}
		bw.write(String.valueOf(Dp(n)));
		
		br.close();
		bw.close();
	}
}