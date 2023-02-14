import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>();
		List<String> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			map.put(tmp, 1);
		}
		for (int i = 0; i < m; i++) {
			String tmp = br.readLine();
			if (map.get(tmp)!=null) {
				arr.add(tmp);
			}

		}
		Collections.sort(arr);
		bw.write(arr.size() + "\n");
		for (int i = 0; i < arr.size(); i++) {
			bw.write(arr.get(i) + "\n");
		}
		br.close();
		bw.close();
	}
}