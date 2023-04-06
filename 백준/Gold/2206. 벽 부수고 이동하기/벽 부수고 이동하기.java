import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int n;
	static int m;
	static int[][] arr;
	static int min = Integer.MAX_VALUE;
	static boolean[][][] v;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		v = new boolean[2][n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		bfs(0, 0);
		
		if (min == Integer.MAX_VALUE)
			bw.write("-1");
		else
			bw.write(String.valueOf(min));
		bw.close();
		br.close();

	}
	static void bfs(int r, int c) {
		Queue<Node>q = new LinkedList<>();
		q.offer(new Node(r,c,1,0));
		v[0][r][c]=true;
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			if(tmp.r==n-1&&tmp.c==m-1) {
				min=Math.min(min, tmp.cnt);
				return;
			}
			for(int i=0;i<4;i++) {
				int nr = tmp.r+dr[i];
				int nc = tmp.c+dc[i];
				if(nr>=0&&nr<n&&nc>=0&&nc<m&&arr[nr][nc]==0&&!v[tmp.b][nr][nc]) {
					
					v[tmp.b][nr][nc]=true;
					q.offer(new Node(nr,nc,tmp.cnt+1,tmp.b));
					
				}
			}
			if(tmp.b==0) {
				for(int i=0;i<4;i++) {
					int nr = tmp.r+dr[i];
					int nc = tmp.c+dc[i];
					if(nr>=0&&nr<n&&nc>=0&&nc<m&&arr[nr][nc]==1&&!v[tmp.b+1][nr][nc]) {
						v[tmp.b+1][nr][nc]=true;
						q.offer(new Node(nr,nc,tmp.cnt+1,tmp.b+1));
						
					}
				}
			}
		}
		
	}
	
}

class Node {
	int r;
	int c;
	int cnt;
	int b;

	Node(int r, int c, int cnt, int b) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
		this.b = b;
	}
}