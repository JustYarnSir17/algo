import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int [][] arr;
	static int [][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr=new int [n][n];
		dp = new int [n][n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0]=arr[0][0];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i-1>=0&&j-1>=0) {
					dp[i][j]=dp[i-1][j]+dp[i][j-1]+arr[i][j]-dp[i-1][j-1];
				}
				else if(i-1>=0&&j-1<0) {
					dp[i][j]=dp[i-1][j]+arr[i][j];
				}
				else if(i-1<0&&j-1>=0) {
					dp[i][j]=dp[i][j-1]+arr[i][j];
				}
			}
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken())-1;
			int y1=Integer.parseInt(st.nextToken())-1;
			int x2=Integer.parseInt(st.nextToken())-1;
			int y2=Integer.parseInt(st.nextToken())-1;
			if(x1==x2&&y1==y2) {
				bw.write(String.valueOf(arr[x1][y1]));
				bw.newLine();
			}
			else {
				if(x1-1>=0&&y1-1>=0) {
					int sum=dp[x2][y2];
					sum-=dp[x1-1][y2];
					sum-=dp[x2][y1-1];
					sum+=dp[x1-1][y1-1];
					bw.write(String.valueOf(sum));
					bw.newLine();
				}
				else if(x1-1>=0&&y1-1<0) {
					int sum=dp[x2][y2];
					sum-=dp[x1-1][y2];
					bw.write(String.valueOf(sum));
					bw.newLine();
				}
				else if(x1-1<0&&y1-1>=0) {
					int sum=dp[x2][y2];
					sum-=dp[x2][y1-1];
					bw.write(String.valueOf(sum));
					bw.newLine();
				}
				else {
					bw.write(String.valueOf(dp[x2][y2]));
					bw.newLine();
				}
			}
		}
		bw.close();
		br.close();
		
	}
	
}