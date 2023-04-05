import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static int w;
	static int h;
	static int[][] arr;
	static int min=Integer.MAX_VALUE;
	static boolean[][][] v;
	static int[] hdr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] hdc = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int[h][w];

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		v=new boolean [k+1][h][w];
		min=bfs(0,0);
		if(min==Integer.MAX_VALUE)
			bw.write("-1");
		else
			bw.write(String.valueOf(min));
		bw.close();
		br.close();

	}
	static int bfs(int r,int c) {
		Queue<Node>q=new LinkedList<>();
		q.offer(new Node(r,c,0,k));
		v[k][r][c]=true;
		while(!q.isEmpty()) {
			Node tmp= q.poll();
			if(tmp.r==h-1&&tmp.c==w-1)return tmp.cnt;
			
			for(int i=0;i<4;i++) {
				int nr= tmp.r+dr[i];
				int nc=tmp.c+dc[i];
				if(nr>=0&&nr<h&&nc>=0&&nc<w&&!v[tmp.k][nr][nc]&&arr[nr][nc]!=1) {
					v[tmp.k][nr][nc]=true;
					q.offer(new Node(nr,nc,tmp.cnt+1,tmp.k));
				}
			
			}
			if(tmp.k>0) {
				for(int i=0;i<8;i++) {
					int nr=tmp.r+hdr[i];
					int nc=tmp.c+hdc[i];
					if(nr>=0&&nr<h&&nc>=0&&nc<w&&!v[tmp.k-1][nr][nc]&&arr[nr][nc]!=1) {
						v[tmp.k-1][nr][nc]=true;
						q.offer(new Node(nr,nc,tmp.cnt+1,tmp.k-1));
					}
				}
			}
		}
		
		return min;
	}

}
class Node{
	int r;
	int c;
	int cnt;
	int k;
	Node(int r, int c,int cnt,int k) {
		this.r=r;
		this.c=c;
		this.cnt=cnt;
		this.k=k;
	}
}