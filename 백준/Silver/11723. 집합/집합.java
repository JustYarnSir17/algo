import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		boolean [] arr = new boolean[21];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			String str1 = st.nextToken();
			int num;
			switch (str1) {
			case "add":
				num = Integer.parseInt(st.nextToken());
				if (arr[num] == false) {
					arr[num] = true;
				}
				break;
			case "check":
				num = Integer.parseInt(st.nextToken());
				if (arr[num] != false) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}

				break;
			case "remove":
				num = Integer.parseInt(st.nextToken());
				if (arr[num] != false) {
					arr[num] = false;
				}

				break;
			case "toggle":
				num = Integer.parseInt(st.nextToken());
				if (arr[num] != false) {
					arr[num] = false;
				} else {
					arr[num] = true;
				}

				break;
			case "all":
				for (int j = 1; j < 21; j++) {
					arr[j] = true;
				}

				break;
			case "empty":
				for (int j = 1; j < 21; j++) {
					arr[j] = false;
				}

				break;

			}

		}
		br.close();
		bw.close();
	}
}