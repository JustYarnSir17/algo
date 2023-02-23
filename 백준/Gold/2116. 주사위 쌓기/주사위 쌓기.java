import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Main {
	static int[][] arr;
	static int top = 0;
	static int sum = 0;
	static int result = 0;
	static int n;
	static int bot = 0;

	static void cal(int i) {
		int max = 0;
		int idx = i + 1;
		for (int j = 0; j < 6; j++) {
			if (arr[idx][j] == top) {// 이전 주사위의 상단 부분과 같은 부분
				switch (j) {// 사실상 현재 주사위 상단 부분
				case 0:
					bot = arr[idx][5];
					break;
				case 1:
					bot = arr[idx][3];
					break;
				case 2:
					bot = arr[idx][4];
					break;
				case 3:
					bot = arr[idx][1];
					break;
				case 4:
					bot = arr[idx][2];
					break;
				case 5:
					bot = arr[idx][0];
					break;
				}
				for (int k = 0; k < 6; k++) {
					if (arr[idx][k] != top && arr[idx][k] != bot) {
						max = Math.max(max, arr[idx][k]);

					}
				}
				top=bot;
				sum += max;
				break;
			}

		}
		if (i + 2 < n) {
			cal(i + 1);
		}
		

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][6];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int j = 0; j < 6; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 0-5,1-3,2-4
		for (int j = 0; j < 6; j++) {
			sum=0;
			top = arr[0][j];
			int max = 0;
			switch (j) {
			case 0:
				bot = arr[0][5];
				break;
			case 1:
				bot = arr[0][3];
				break;
			case 2:
				bot = arr[0][4];
				break;
			case 3:
				bot = arr[0][1];
				break;
			case 4:
				bot = arr[0][2];
				break;
			case 5:
				bot = arr[0][0];
				break;
			}
			for (int k = 0; k < 6; k++) {
				if (arr[0][k] != top && arr[0][k] != bot) {
					max = Math.max(max, arr[0][k]);

				}
			}
			sum += max;
			cal(0);
			result=Math.max(result, sum);
		}
		bw.write(String.valueOf(result));
		bw.close();
		br.close();
		
	}

}