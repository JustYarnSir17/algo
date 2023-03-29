import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main {
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		p = new int[n + 1];
		long sum=0;
		int[][] edges = new int[m][3];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
			sum+=edges[i][2];
		}

		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}
		});
		for (int i = 0; i < n + 1; i++) {
			p[i] = i;
		}
		long result = 0;
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			if (findset(edges[i][0]) != findset(edges[i][1])) {
				union(edges[i][0], edges[i][1]);
				result += edges[i][2];
				cnt++;
			}
			if (cnt == n - 1)
				break;
		}
		int[] count = new int[n + 1];
		for (int i = 1; i <= n; i++)
			findset(i);
		for (int i = 1; i <= n; i++) {
			if (p[i] != 0) {
				count[p[i]]++;
			}
		}
		cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (count[i] != 0)
				cnt++;
			if (cnt > 1) {
				bw.write("-1");
				bw.close();
				br.close();
				return;
			}
		}
		bw.write(String.valueOf(sum-result));
		bw.close();
		br.close();
		

	}

	private static void union(int i, int j) {
		// TODO Auto-generated method stub
		p[findset(i)] = findset(j);

	}

	private static int findset(int j) {
		// TODO Auto-generated method stub
		if (p[j] == j)
			return j;
		p[j] = findset(p[j]);
		return p[j];
	}
}