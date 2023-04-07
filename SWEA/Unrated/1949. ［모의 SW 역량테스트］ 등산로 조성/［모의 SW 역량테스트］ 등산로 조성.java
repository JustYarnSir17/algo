import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n, k;
	static int[][] arr;
	static int max;
	static int result;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			result=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			v = new boolean[n][n];
			max = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, arr[i][j]);

				}
			}
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == max) {
						v[i][j]=true;
						dfs(i,j,1,false);
						v[i][j]=false;
					}
				}
			}

			bw.write("#"+t+" "+result);
			bw.newLine();
			
		}
		bw.close();
		br.close();
	}

	static void dfs(int r, int c, int cnt,boolean fl) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
				if(arr[nr][nc]<arr[r][c]&&!v[nr][nc]) {
					v[nr][nc]=true;
					dfs(nr,nc,cnt+1,fl);
					v[nr][nc]=false;
				}
				else if(arr[nr][nc]>=arr[r][c]&&!v[nr][nc]){
					if(!fl) {
						if(arr[nr][nc]-arr[r][c]<k) {
							int tmp = arr[nr][nc];
							arr[nr][nc]-=arr[nr][nc]-arr[r][c]+1;
							v[nr][nc]=true;
							dfs(nr,nc,cnt+1,true);
							v[nr][nc]=false;
							arr[nr][nc]=tmp;
						}
					}
				}
			}

		}
		result= Math.max(result, cnt);

	}

}