import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int [][]arr;
	static int n,m;
	static boolean[][] v;
	static int []dr= {1,-1,0,0,1,-1,1,-1};
	static int []dc= {0,0,1,-1,1,1,-1,-1};
	static void bfs(int c, int r) {
		Queue<Pair> q = new LinkedList<>();
		v[c][r]=true;
		q.add(new Pair(c,r));
		while(!q.isEmpty()) {
			Pair tmp = q.poll();
			for(int i=0;i<8;i++) {
				int nc = tmp.c+dc[i];
				int nr = tmp.r+dr[i];
				if(nc>=0&&nc<n&&nr>=0&&nr<m) {
					if(arr[nc][nr]==1&&v[nc][nr]!=true) {
						v[nc][nr]=true;
						q.add(new Pair(nc,nr));
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		do {
			String str= br.readLine();
			StringTokenizer st = new StringTokenizer(str," ");
			m=Integer.parseInt(st.nextToken());
			n=Integer.parseInt(st.nextToken());
			if(m==0&&n==0) {
				break;
			}
			arr= new int [n][m];
			v=new boolean [n][m];
			for(int i=0;i<n;i++) {
				String tmp = br.readLine();
				st=new StringTokenizer(tmp," ");
				for(int j=0;j<m;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
					
				}
			}
			int sum=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
 
					if(arr[i][j]==1&&v[i][j]!=true) {
						sum++;
						bfs(i,j);
					}
				}
			}
			bw.write(String.valueOf(sum));
			bw.newLine();
		}while(m!=0&&n!=0);
		
		
		bw.close();
		br.close();
	}
}

class Pair{
	int c;
	int r;
	Pair(int c, int r){
		this.c=c;
		this.r=r;
	}
}