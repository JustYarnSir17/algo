import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int n;
	static int m;
	static boolean[][] v;
	static int num=0;
	static int max=0;
	
	
	static void bfs(int y,int x) {
		Queue<Pair> q = new LinkedList<>();
		v[y][x]=true;
		q.add(new Pair(y,x));
		int count=0;
		while(!q.isEmpty()) {
			
			Pair tmp = q.poll();
			
			count++;
			for(int i=0;i<4;i++) {
				int nr= tmp.x+dr[i];
				int nc=tmp.y+dc[i];
				if(nr>=0&&nr<m&&nc>=0&&nc<n) {
					if(arr[nc][nr]==1&&v[nc][nr]!=true) {
						q.add(new Pair(nc,nr));
						v[nc][nr]=true;
					}
				}
			}
		}
		max=Math.max(max, count);
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str =br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr=new int [n][m];
		v=new boolean[n][m];
		for(int i=0;i<n;i++) {
			str=br.readLine();
			st = new StringTokenizer(str," ");
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==1&&v[i][j]!=true) {
					num++;
					bfs(i,j);
				}
			}
		}
		
		bw.write(num+"\n"+max);
		
		bw.close();
		br.close();
	}
}
class Pair{
	int y;
	int x;
	Pair(int y,int x){
		this.y=y;
		this.x=x;
	}
}