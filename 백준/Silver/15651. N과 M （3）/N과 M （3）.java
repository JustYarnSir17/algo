import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static Stack<Integer> stack = new Stack<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	static void dfs(int cnt) throws IOException {
		if (cnt == m - 1) {
			for (int i = 0; i < n; i++) {
				bw.write(sb.toString() + arr[i]);
				bw.newLine();
			}
			return;
		} else {
			for (int i = 0; i < n; i++) {
				sb.append(arr[i]+" ");
				dfs(cnt + 1);
				sb.delete(sb.length()-2, sb.length());
			}

		}

	}

	public static void main(String[] args) throws IOException {

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		dfs(0);

		bw.close();
		br.close();

	}

}