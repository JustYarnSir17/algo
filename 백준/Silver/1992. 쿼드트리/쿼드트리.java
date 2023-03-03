import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;

	static void cal(int n,int r,int c) {

		int sum0 = 0;
		int sum1 = 0;
		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				if (arr[i][j] == 1) {
					sum1++;
				} else {
					sum0++;
				}
			}
		}

		if (sum0 == n * n) {
			sb.append("0");
		} else if (sum1 == n * n) {
			sb.append("1");
		}
		else {
			int tmp = n/2;
			int []dr= {r,r,r+tmp,r+tmp};
			int []dc= {c,c+tmp,c,c+tmp};

			sb.append("(");
			for(int i=0;i<4;i++) {
				cal(tmp,dr[i],dc[i]);
			}
			

			sb.append(")");
		}
	}

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		cal(n,0,0);

		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}