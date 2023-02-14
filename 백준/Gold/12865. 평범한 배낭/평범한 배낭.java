import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] w= new int [n+1];
		int[] v= new int [n+1];
		int[][] dp = new int [101][100001];
		for(int i=1;i<=n;i++) {
			str = br.readLine();
			st = new StringTokenizer(str," ");
			w[i]=Integer.parseInt(st.nextToken());
			v[i]=Integer.parseInt(st.nextToken());
			
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				if(j-w[i]>=0) {
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
				}
				else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		bw.write(String.valueOf(dp[n][k]));
		br.close();
		bw.close();
		
	}
}