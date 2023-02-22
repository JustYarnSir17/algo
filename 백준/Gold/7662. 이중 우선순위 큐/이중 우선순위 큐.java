import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> q = new TreeMap<>();
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				String a = st.nextToken();
				int b = Integer.parseInt(st.nextToken());
				if (a.equals("I")) {
					q.put(b, q.getOrDefault(b, 0) + 1);

				} else {
					if (q.size() == 0) {
						continue;
					}
					int tmp =b == 1 ? q.lastKey() : q.firstKey();
					if (q.put(tmp, q.get(tmp) - 1) == 1) {
						q.remove(tmp);
					}

				}

			}
			bw.write(q.size()==0?"EMPTY":q.lastKey()+" "+q.firstKey());
			bw.newLine();

		}

		bw.close();
		br.close();

	}

}