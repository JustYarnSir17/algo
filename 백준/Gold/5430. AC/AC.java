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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String str1 = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String str2 = br.readLine();
			StringTokenizer st = new StringTokenizer(str2, "[],");
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			boolean er = false;
			boolean fl = false;
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) == 'R') {
					if (fl) {
						fl = false;

					} else {
						fl = true;
					}
				} else if (str1.charAt(i) == 'D') {
					if (list.isEmpty()) {
						er = true;
						break;
					} else {
						if (fl) {// R 홀수
							list.remove(list.size() - 1);
						} else {// R 짝수
							list.remove(0);
						}
					}
				}
			}
			if (er) {

				bw.write("error");
				bw.newLine();
			} else {

				if (list.isEmpty()) {
					bw.write("[]");
					bw.newLine();
				} else {
					bw.write("[");
					if (fl) {
						for (int i = list.size() - 1; i > 0; i--) {
							bw.write(list.get(i) + ",");
						}
						bw.write(list.get(0) + "]");
						bw.newLine();
					} else {
						for (int i = 0; i < list.size() - 1; i++) {
							bw.write(list.get(i) + ",");
						}
						bw.write(list.get(list.size() - 1) + "]");
						bw.newLine();
					}
				}
			}
		}
		bw.close();
		br.close();
	}
}