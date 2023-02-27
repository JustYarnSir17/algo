import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		int [] dp = new int [1001];
		dp[1]=1;
		dp[2]=3;
		for(int i=3;i<1001;i++) {
			dp[i]=(dp[i-2]*2+dp[i-1])%10007;
		}
		bw.write(String.valueOf(dp[n]));
		

		bw.close();
		br.close();
	}
}