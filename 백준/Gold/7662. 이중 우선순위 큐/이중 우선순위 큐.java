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

public class Main {
	static int del(PriorityQueue<Integer> q, Map<Integer, Integer> map) {
		int num;
		while (true) {
			num = q.poll();
			int cnt = map.getOrDefault(num, 0);
			if (cnt == 0)
				continue;

			if (cnt == 1)
				map.remove(num);

			else
				map.put(num, cnt - 1);

			break;
		}
		return num;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			PriorityQueue<Integer> minq = new PriorityQueue<>();
			PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
			Map<Integer, Integer> map = new HashMap<>();
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				String a = st.nextToken();
				int b = Integer.parseInt(st.nextToken());
				if (a.equals("I")) {
					minq.add(b);
					maxq.add(b);
					
					map.put(b, map.getOrDefault(b, 0) + 1);

				} else {
					if (map.size() == 0) {
						continue;
					}
					PriorityQueue<Integer> q = b == 1 ? maxq : minq;
					del(q, map);

				}

			}
			if (map.size() == 0) {
				bw.write("EMPTY");
				bw.newLine();
			} else {
				int tmp = del(maxq, map);
				bw.write(tmp + " " + (map.size() > 0 ? del(minq, map) : tmp));
				bw.newLine();
			}

		}

		bw.close();
		br.close();

	}

}