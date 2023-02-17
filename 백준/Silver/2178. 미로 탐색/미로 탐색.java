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
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static boolean[][] v;
	static int[][] dp;
	static int n;
	static int m;

	static void bfs() {

		v[1][1]=true;
		dp[1][1]=1;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(1,1));
		while(!q.isEmpty()) {
			Pair tmp = q.poll();
			for(int i=0;i<4;i++) {
				int nr= tmp.r+dr[i];
				int nc= tmp.c+dc[i];
				if(nr>0&&nr<=m&&nc>0&&nc<=n) {
					if(arr[nc][nr]==1&&v[nc][nr]!=true) {
						v[nc][nr]=true;
						dp[nc][nr]=Math.max(dp[nc][nr], dp[tmp.c][tmp.r]+1 );
						q.add(new Pair(nc,nr));
					}
				}
			}
			
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][m + 1];
		v = new boolean[n + 1][m + 1];
		dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			str = br.readLine();
			for (int j = 1; j <= m; j++) {
				arr[i][j] = str.charAt(j - 1)-'0';
			}
		}
		bfs();
		
		bw.write(String.valueOf(dp[n][m]));
		bw.close();
		br.close();
	}
}

class Pair{
	int c;
	int r;
	Pair(int c,int r){
		this.c=c;
		this.r=r;
	}
}