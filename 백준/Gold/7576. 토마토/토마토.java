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
	static int[][] arr;
	static boolean[][]v;
	static int [] dr = {1,-1,0,0};
	static int [] dc = {0,0,1,-1};
	static int cnt=0;
	static int n;
	static int m;
	static int z;
	static int y;
	static int count=0;
	static int max=0;
	
	static List<Pair> list = new ArrayList<>();
	static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		for(int i=0;i<list.size();i++) {
			q.add(new Pair(list.get(i).c,list.get(i).r,0));
			v[list.get(i).c][list.get(i).r]=true;
		}
		
		while(!q.isEmpty()) {
			int cal =0;
			Pair tmp = q.poll();
			v[tmp.c][tmp.r]=true;
			max=Math.max(max, tmp.day);
			for(int i=0;i<4;i++) {
				int nr = tmp.r+dr[i];
				int nc = tmp.c+dc[i];
				if(nr>=0&&nr<m&&nc>=0&&nc<n) {
					if(arr[nc][nr]==0&&v[nc][nr]!=true) {
						v[nc][nr]=true;
						q.add(new Pair(nc,nr,tmp.day+1));
						
						y++;
						z--;
						
					}
				}

			}
			
		}
		
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		 m=Integer.parseInt(st.nextToken());
		 n =Integer.parseInt(st.nextToken());
		arr=new int [n][m];
		v=new boolean [n][m];
		int result=0;
		for(int i=0;i<n;i++) {
			str= br.readLine();
			st=new StringTokenizer(str," ");
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==1) {
					y++;
					cnt++;
					list.add(new Pair(i,j,0));
				}
				else if (arr[i][j]==0){
					z++;
				}
			}
		}
		if(z==0) {
			result=0;
		}
		else {
			bfs();
		}
		if(z!=0) {
			result=-1;
		}
		else {
			result=max;
		}
		
		bw.write(String.valueOf(result));
		bw.close();
		br.close();
	}
}

class Pair{
	int c;
	int r;
	int day;
	Pair(int c,int  r,int d){
		this.c=c;
		this.r=r;
		this.day=d;
	}
}