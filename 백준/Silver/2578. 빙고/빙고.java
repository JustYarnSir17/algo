import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] arr = new int[5][5];
		int[] r = new int[5];//행 체크
		int[] c = new int[5];//열 체크
		int[] d = new int[2];//대각선 체크
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		cal: for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int j = 0; j < 5; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				count++;
				for (int k = 0; k < 5; k++) {
					for (int l = 0; l < 5; l++) {
						if (arr[k][l] == tmp) {
							r[k] ++ ;//k행 체크
							c[l] ++;//l열 체크
							if (k == l) {//대각선 체크
								d[0] ++;
							} if (k == 5 - l - 1) {//대각선 체크
								d[1] ++;
							}
							

						}
						

					}
					
				}
				for(int a=0;a<5;a++) {
					if(r[a]==5)
					{
						sum++;
						r[a]=-1;
					}
					if(c[a]==5) {
						sum++;
						c[a]=-1;
						
					}
					
				}
				if(d[0]==5) {
					sum++;
					d[0]=-1;
				}
				if(d[1]==5) {
					sum++;
					d[1]=-1;
				}
				if(sum>=3)
					break cal;
				
			}
		}
		bw.write(String.valueOf(count));

		bw.close();
		br.close();

	}

}