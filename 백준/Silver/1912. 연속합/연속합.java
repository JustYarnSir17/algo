import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int [] arr= new int [n];
		int [] dp = new int [n];
		String str= br.readLine();
		
		StringTokenizer st = new StringTokenizer(str," ");
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			dp[i]=Integer.MIN_VALUE;
		}
		dp[0]=arr[0];
		for(int i=1;i<n;i++) {
			dp[i]=Math.max(arr[i],dp[i-1]+arr[i]);
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			max=Math.max(max, dp[i]);
		}
		bw.write(String.valueOf(max));
		
		br.close();
		bw.close();
	}

}