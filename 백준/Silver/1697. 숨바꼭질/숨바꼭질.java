import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] fl = new boolean[200001];
	static int[] arr = new int[200001];

	static int bfs(int n, int k) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		fl[n] = true;
		while (!q.isEmpty()) {
			int tmp = q.poll();
			if (tmp - 1 >= 0) {
				if (!fl[tmp - 1]) {
					q.add(tmp - 1);
					fl[tmp - 1] = true;
					arr[tmp - 1] = arr[tmp] + 1;
				}

			}
			if (tmp + 1 < 200000) {
				if (!fl[tmp + 1]) {
					q.add(tmp + 1);
					fl[tmp + 1] = true;
					arr[tmp + 1] = arr[tmp] + 1;

				}

			}
			if (tmp * 2 < 200000) {
				if (!fl[tmp * 2]) {
					q.add(tmp * 2);
					fl[tmp * 2] = true;
					arr[tmp * 2] = arr[tmp] + 1;
				}
			}
		}
		return arr[k];
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int count = bfs(n,k);
		
		bw.write(String.valueOf(count));

		bw.close();
		br.close();
	}
}