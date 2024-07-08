import  java.util.*;
import java.io.*;

public class Main {

	static int cnt=0;
	static int n;
	static int m;
	static int[][] arr;
	static boolean[][]v;
	static Stack<Pair>  stack =new Stack<>();
	static int[] dr= {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n =Integer.parseInt(st.nextToken());
		m =Integer.parseInt(st.nextToken());
		int k =Integer.parseInt(st.nextToken());
		
		arr = new int [n][m];
		v= new boolean[n][m];
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int r= Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());
			
			arr[r-1][c-1]=1;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==1&&v[i][j]==false) {
					dfs(i,j);
				}
			}
			
		}
		bw.write(cnt+"");
		bw.close();
		br.close();
	}
	
	public static void dfs(int r,int c) {
		v[r][c]=true;
		int count=1;
		stack.push(new Pair(r,c));
		while(!stack.isEmpty()) {
			Pair tmp = stack.pop();
			for(int i=0;i<4;i++) {
				int nr = tmp.r+dr[i];
				int nc = tmp.c+dc[i];
				if(nr<0||nr>=n||nc<0||nc>=m)
					continue;
				if(arr[nr][nc]==1&&v[nr][nc]==false) {
					v[nr][nc]=true;
					++count;
					stack.push(new Pair(nr,nc));
				}
			}
		}
		cnt=Math.max(cnt,count);
	}

}

class Pair{
	int r;
	int c;
	Pair(int r,int c){
		this.r=r;
		this.c=c;
	}
}