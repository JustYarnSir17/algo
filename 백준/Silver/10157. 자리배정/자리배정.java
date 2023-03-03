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
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		int[][] arr = new int[r][c];
		boolean f1 = false;// 행
		boolean f2 = false;// 열
		int val = 0;
		int idx1 = r;
		int idx2 = 0;
		while (val <= c * r) {

			while (!f1 && !f2) {
				if (arr[idx1 - 1][idx2] == 0) {
					arr[--idx1][idx2] = ++val;
				}
				if (idx1 - 1 < 0 || arr[idx1 - 1][idx2] != 0) {
					f1 = true;
					break;
				}
			}
			if (val >= c * r)
				break;
			while (f1 && !f2) {
				if (arr[idx1][idx2 + 1] == 0) {
					arr[idx1][++idx2] = ++val;
				}
				if (idx2 + 1 >= c || arr[idx1][idx2 + 1] != 0) {
					f2 = true;
					break;
				}

			}
			while (f1 && f2) {
				if (arr[idx1 + 1][idx2] == 0) {
					arr[++idx1][idx2] = ++val;
				}
				if (idx1 + 1 >= r || arr[idx1 + 1][idx2] != 0) {
					f1 = false;
					break;
				}

			}
			while (!f1 && f2) {
				if (arr[idx1][idx2 - 1] == 0) {
					arr[idx1][--idx2] = ++val;
				}
				if (idx2 - 1 < 0 || arr[idx1][idx2 - 1] != 0) {
					f2 = false;
					break;
				}

			}
		}
		int x=1;
		int y=r;
		if (k > c * r) {
			bw.write("0");
		} else {
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (arr[i][j] == k) {
						x+=j;
						y-=i;
						
					}
				}
			}

			bw.write(x+" "+y);
		}
		bw.close();
		br.close();

	}
}