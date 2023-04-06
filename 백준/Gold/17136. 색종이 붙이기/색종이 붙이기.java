import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[] paper = { 0, 5, 5, 5, 5, 5 };
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		arr = new int[10][10];
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		dfs(0);
		if(min==Integer.MAX_VALUE)
			bw.write("-1");
		else {
			bw.write(String.valueOf(min));
		}
		bw.close();
		br.close();
	}

	static void dfs(int cnt) {
		int R = -1;
		int C = -1;
		roop: for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (arr[r][c] == 1) {
					R = r;
					C = c;
					break roop;
				}
			}
		}

		if (R == -1 && C == -1) {
			min = Math.min(min, cnt);
			return;
		}
		int max = 5;
		while (max > 0) {
			boolean fl = true;
			for (int r = 0; r < max; r++) {
				for (int c = 0; c < max; c++) {
					if (R + r >= 10 || C + c >= 10 || arr[R + r][C + c] == 0) {
						fl = false;
						break;
					}
				}
			}
			if(fl)
				break;
			max--;

		}
		for(int size =1; size<=max;size++) {
			if(paper[size]==0)
				continue;
			paste(R,C,size,0);
			paper[size]--;
			dfs(cnt+1);
			paste(R,C,size,1);
			paper[size]++;
		}
	}

	private static void paste(int r, int c, int size, int i) {
		// TODO Auto-generated method stub
		for(int R=r;R<r+size;R++) {
			for(int C=c;C<c+size;C++) {
				arr[R][C]=i;
			}
		}
		
	}

}