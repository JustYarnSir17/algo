import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int [][] dp;
	static int n,m;
	static int [] dr= {1,0,1};
	static int [] dc= {0,1,1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st =new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr= new int [n][m];
		dp=new int [n][m];
		
		for(int i=0;i<n;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(i==0&&j==0) {
					dp[i][j]=arr[i][j];
				}
				else {
					if(i-1>=0&&j==0) {
						dp[i][j]=dp[i-1][j]+arr[i][j];
					}
					else if(j-1>=0&&i==0) {
						dp[i][j]=dp[i][j-1]+arr[i][j];
					}
					else if(i>0&&j>0&&i<n&&j<m) {
						dp[i][j]=Math.max(dp[i-1][j-1]+arr[i][j], dp[i-1][j]+arr[i][j]);
						dp[i][j]=Math.max(dp[i][j], dp[i][j-1]+arr[i][j]);
					}
				}
			}
		}
		bw.write(dp[n-1][m-1]+"");
		bw.close();
		br.close();
		
		
		
		bw.close();
		br.close();
		
		
	}

}