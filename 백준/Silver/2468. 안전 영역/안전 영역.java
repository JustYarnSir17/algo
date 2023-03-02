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
	static int[][] b;
	static int n;
	static boolean[][] v;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int max = 0;

	static void bfs(int c, int r) {
		Queue<Pair> q = new LinkedList<>();
		v[c][r] = true;
		q.add(new Pair(c, r));
		while (!q.isEmpty()) {
			Pair tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nc = tmp.c + dc[i];
				int nr = tmp.r + dr[i];
				if (nc >= 0 && nc < n && nr >= 0 && nr < n) {

					if (b[nc][nr] > 0 && v[nc][nr] != true) {

						v[nc][nr] = true;
						q.add(new Pair(nc, nr));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		while (true) {
			b = new int[n][n];
			v = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {

					b[i][j] = arr[i][j] - count;

				}
			}
			int sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {

					if (b[i][j] > 0 && v[i][j] != true) {

						bfs(i, j);
						sum++;

					}
				}
			}
			max = Math.max(max, sum);
			count++;
			if (sum == 0)
				break;
		}
		bw.write(String.valueOf(max));
		bw.newLine();
		bw.close();
		br.close();
	}
}

class Pair {
	int c;
	int r;

	Pair(int c, int r) {
		this.c = c;
		this.r = r;
	}
}