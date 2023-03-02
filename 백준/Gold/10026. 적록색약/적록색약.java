import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int [] dr = {1,-1,0,0};
	static int [] dc = {0,0,1,-1};
	static boolean[][] v;
	static int n; 
	static char[][] arr ;
	
	static int non=0;
	static int gr=0;
	
	static void bfs(int r,int c,char col) {
		Queue <Pair>q= new LinkedList<>();
		v[r][c]=true;
		q.offer(new Pair(r,c,col));
		while(!q.isEmpty()) {
			Pair tmp=q.poll();
			for(int i=0;i<4;i++) {
				int nr = tmp.r+dr[i];
				int nc =tmp.c+dc[i];
				if(nr>=0&&nr<n&&nc>=0&&nc<n) {
					if(v[nr][nc]!=true&&arr[nr][nc]==arr[tmp.r][tmp.c]) {
						v[nr][nc]=true;
						q.offer(new Pair(nr,nc,arr[nr][nc]));
					}
				}
			}
		}
	
	}
	static void bfs() {
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n =Integer.parseInt(br.readLine());
		arr =new char[n][n];
		v=new boolean[n][n];
		for(int i=0;i<n;i++) {
			String str= br.readLine();
			for(int j=0;j<n;j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(v[i][j]!=true)
				{bfs(i,j,arr[i][j]);
				non++;}
				
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				v[i][j]=false;
				if(arr[i][j]=='R')
					arr[i][j]='G';
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(v[i][j]!=true) {

					bfs(i,j,arr[i][j]);
					gr++;
				}
			}
		}
		bw.write(non+" "+gr);
		
		
		bw.close();
		br.close();
	}
}
class Pair{
	int r;
	int c;
	char color;
	Pair(int r,int c,char col){
		this.r=r;
		this.c=c;
		this.color=col;
	}
}