import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] arr;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int min = Integer.MIN_VALUE;
	static ArrayList<loc> list = new ArrayList<>();

	static void bfs(int[][] b) {
		Queue<loc> q = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			q.add(list.get(i));
		}
		while (!q.isEmpty()) {
			loc tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = tmp.r + dr[i];
				int nc = tmp.c + dc[i];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
					if (b[nr][nc] == 0) {
						b[nr][nc] = 2;
						q.offer(new loc(nr, nc));
					}
				}
			}

		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (b[i][j] == 0) {
					count++;
				}
			}
		}
		min = Math.max(min, count);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					list.add(new loc(i, j));
				}
			}
		}

		for (int i1 = 0; i1 < n; i1++) {
			for (int j1 = 0; j1 < m; j1++) {
				
				if (arr[i1][j1] == 0) {
					arr[i1][j1] = 1;

					for (int i2 = 0; i2 < n; i2++) {
						for (int j2 = 0; j2 < m; j2++) {
							if (arr[i2][j2] == 0) {
								arr[i2][j2] = 1;

								for (int i3 = 0; i3 < n; i3++) {
									for (int j3 = 0; j3 < m; j3++) {

										if (arr[i3][j3] == 0) {

											arr[i3][j3] = 1;
											int[][] b = new int[n][m];
											for (int i = 0; i < n; i++) {
												for (int j = 0; j < m; j++) {
													b[i][j] = arr[i][j];

												}
											}
											bfs(b);
											arr[i3][j3]=0;
										}

									}
								}
								arr[i2][j2]=0;
							}
						}
					}
					arr[i1][j1]=0;
				}
			}
		}
		bw.write(String.valueOf(min));

		bw.close();
		br.close();

	}
}

class loc {
	int r;
	int c;

	loc(int r, int c) {
		this.r = r;
		this.c = c;
	}

}