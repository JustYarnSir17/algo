import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int n;
	static int[][] maxdp;
	static int [][] mindp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][3];
		maxdp = new int[n][3];
		mindp = new int[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}

		}
		for(int i=0;i<3;i++) {
			maxdp[0][i]=arr[0][i];
			mindp[0][i]=arr[0][i];
		}
		for(int i=1;i<n;i++) {
			maxdp[i][0]=Math.max(maxdp[i-1][0]+arr[i][0], maxdp[i-1][1]+arr[i][0]);
			maxdp[i][1]=Math.max(maxdp[i-1][0]+arr[i][1], maxdp[i-1][1]+arr[i][1]);
			maxdp[i][1]=Math.max(maxdp[i][1], maxdp[i-1][2]+arr[i][1]);
			maxdp[i][2]=Math.max(maxdp[i-1][1]+arr[i][2], maxdp[i-1][2]+arr[i][2]);
			mindp[i][0]=Math.min(mindp[i-1][0]+arr[i][0], mindp[i-1][1]+arr[i][0]);
			mindp[i][1]=Math.min(mindp[i-1][0]+arr[i][1], mindp[i-1][1]+arr[i][1]);
			mindp[i][1]=Math.min(mindp[i][1], mindp[i-1][2]+arr[i][1]);
			mindp[i][2]=Math.min(mindp[i-1][1]+arr[i][2], mindp[i-1][2]+arr[i][2]);
		}
		int max=0;
		int min =Integer.MAX_VALUE;
		for(int i=0;i<3;i++) {
			max=Math.max(max, maxdp[n-1][i]);
			min=Math.min(min, mindp[n-1][i]);
		}
		bw.write(max+" "+min);
		bw.close();
		br.close();
		
		
	}

}