import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int b=0;
	static int w=0;
	static void cal(int n, int[][] arr) {
		int white=0;
		int blue=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==1) {
					blue++;
				}
				else {
					white++;
				}
			}
		}
		if(blue!=n*n&&white!=n*n) {
			int p=n/2;
			int[] dc = {0,0,p,p};
			int[] dr= {0,p,0,p};
			int idx1=0,idx2=0;
			int[][]b=new int [p][p];
			for(int i=0;i<4;i++) {idx1=0;
				for(int j=dc[i];j<dc[i]+p;j++) {
					idx2=0;
					for(int k=dr[i];k<dr[i]+p;k++) {
						b[idx1][idx2]=arr[j][k];
						idx2++;
					}
					idx1++;
				}
				cal(p,b);
			}
			
			
		}
		else if(blue==n*n) {
			b++;
			return;
		}
		else if(white==n*n) {
			w++;
			return;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		cal(n,arr);
		
		bw.write(w+"\n"+b);

		bw.close();
		br.close();
	}
}