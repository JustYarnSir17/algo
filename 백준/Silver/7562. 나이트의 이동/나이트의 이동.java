import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int [][] arr;
	static int n;
	static int [] dr= {-2,-1,1,2,2,1,-1,-2};
	static int [] dc = {-1,-2,-2,-1,1,2,2,1};
	static int [][] v;
	static void bfs(int r, int c) {
		v[r][c]=1;
		Queue<loc> q = new LinkedList<>();
		q.offer(new loc(r,c,1));
		while(!q.isEmpty()) {
			loc tmp = q.poll();
			for(int i=0;i<8;i++) {
				int nr = tmp.r+dr[i];
				int nc = tmp.c+dc[i];
				if(nr>=0&&nr<n&&nc>=0&&nc<n) {
					if(v[nr][nc]==0) {
						v[nr][nc]=tmp.cnt+1;
						q.offer(new loc(nr,nc,tmp.cnt+1));
					}
				}
			}
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T=Integer.parseInt(br.readLine());
		for(int t = 0;t<T;t++) {
			n=Integer.parseInt(br.readLine());
			arr= new int [n][n];
			v=new int [n][n];
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str," ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[r][c]=1;
			str = br.readLine();
			st = new StringTokenizer(str," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y]=2;
			bfs(r,c);
			bw.write(String.valueOf(v[x][y]-1));
			bw.newLine();
		}
		bw.close();
		br.close();
	}
	
}
class loc{
	int r;
	int c;
	int cnt;
	loc(int r,int c,int cnt){
		this.r=r;
		this.c=c;
		this.cnt=cnt;
	}
}