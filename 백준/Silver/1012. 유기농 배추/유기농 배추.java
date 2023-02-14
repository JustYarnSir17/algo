import java.util.*;
import java.io.*;

public class Main {
	static int m,n,k;
	static int [][] arr;
	static boolean [][] v;
	static int count;
	static int []dr= {1,-1,0,0};
	static int []dc = {0,0,1,-1};
	
	static void bfs(int y,int x) {
		Queue<Pair> q= new LinkedList<Pair>();
		q.add(new Pair(y,x));
		while(!q.isEmpty()) {
			y = q.peek().getR();
			x=q.peek().getC();
			v[y][x]=true;
			q.poll();
			for(int i=0;i<4;i++) {
				int nr = y+dr[i];
				int nc = x+dc[i];
				if(nr>=0&&nr<n&&nc>=0&&nc<m) {
					if(!v[nr][nc]&&arr[nr][nc]==1) {
						q.add(new Pair(nr,nc));
						v[nr][nc]=true;
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			m= Integer.parseInt(st.nextToken());
			n= Integer.parseInt(st.nextToken());
			k=Integer.parseInt(st.nextToken());
			arr= new int [n][m];
			v= new boolean[n][m];
			count= 0;
			for(int j=0;j<k;j++) {
				st=new StringTokenizer(br.readLine()," ");
				int x= Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[y][x]=1;
			}
			for(int j=0;j<n;j++) {
				for(int l=0;l<m;l++) {
					if(arr[j][l]==1&&!v[j][l]) {
						bfs(j,l);
						count++;
					}
				}
			}
			
			System.out.println(count);
			
		
	}
}
}

class Pair{
	private int r;
	private int c;
	Pair(int r,int c){
		this.r=r;
		this.c=c;
		
	}
	
	public int getR() {
		return this.r;
		
	}
	public int getC() {
		return this.c;
	}
}