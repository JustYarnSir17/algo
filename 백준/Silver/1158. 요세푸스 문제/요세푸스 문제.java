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
		Queue<Integer> q = new LinkedList<>();
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}
		int tmp = 0;
		int idx = 1;
		bw.write("<");
		while (!q.isEmpty()) {
			if (idx % k == 0) {
				tmp = q.poll();
				if (q.isEmpty())
					break;
				else
					bw.write(tmp + ", ");
			} else {
				tmp = q.poll();
				q.offer(tmp);
			}
			idx++;
		}
		bw.write(tmp + ">");

		bw.close();
		br.close();
	}
}