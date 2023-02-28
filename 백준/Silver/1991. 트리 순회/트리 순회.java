import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static char[] arr;
	static int MAX = (int)Math.pow(2, 26);

	static void pre(int t) throws IOException {
		if (t <= MAX-1) {
			if (arr[t] != '\0' && arr[t] != '.') {
				bw.write(arr[t]);

			}
			pre(2 * t);
			pre(2 * t + 1);
		}
	}

	static void in(int t) throws IOException {
		if (t <= MAX-1) {
			in(2 * t);
			if (arr[t] != '\0' && arr[t] != '.') {

				bw.write(arr[t]);

			}
			in(2 * t + 1);
		}
	}

	static void post(int t) throws IOException {
		if (t <= MAX-1) {
			post(2 * t);
			post(2 * t + 1);
			if (arr[t] != '\0' && arr[t] != '.') {

				bw.write(arr[t]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());

		arr = new char[MAX];
		arr[1] = 'A';
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			char p = str.charAt(0);
			char c1 = str.charAt(2);
			char c2 = str.charAt(4);

			for (int j = 1; j < MAX-1; j++) {
				if (arr[j] == p) {
					if (c1 != '.') {

						arr[j * 2] = c1;
					}
					if (c2 != '.') {

						arr[j * 2 + 1] = c2;
					}
				}

			}

		}
		// 전위 순회: 부모 노드 방문후 좌우 자식
		// 중위 순회: 왼쪽 자식 -> 부모-> 오른쪽 자식
		// 후위 순회: 좌우 자식 -> 부모
		pre(1);
		bw.newLine();
		in(1);
		bw.newLine();
		post(1);
		bw.close();
		br.close();
	}

}