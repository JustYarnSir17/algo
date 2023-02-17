import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int [][]arr;
	static int [][]v;
	static int num=1;
	static int [] dr= {1,-1,0,0};
	static int [] dc= {0,0,1,-1};
	static int n;
	
	static void bfs(int c,int r) {
		Queue<Pair> q = new LinkedList<>();
		v[c][r]=1;
		arr[c][r]=num;
		q.add(new Pair(c,r));
		while(!q.isEmpty()) {
			Pair  tmp = q.poll();
			for(int i=0;i<4;i++) {
				int nc=tmp.c+dc[i];
				int nr = tmp.r+dr[i];
				if(nc>=0&&nc<n&nr>=0&&nr<n) {
					if(arr[nc][nr]==1&&v[nc][nr]==0) {
						v[nc][nr]=1;
						arr[nc][nr]=num;
						q.add(new Pair(nc,nr));
					}
				}
			}
		}
	}
	
	

	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n=Integer.parseInt(br.readLine());
		arr= new int [n][n];
		v=new int [n][n];
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<n;j++) {
				arr[i][j]=str.charAt(j)-'0';
				
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==1) {
					num++;
					bfs(i,j);
				}
			}
		}
		bw.write(String.valueOf(num-1));
		bw.newLine();
		int idx=0;
		int [] s=new int [num-1];
		for(int i=2;i<=num;i++) {
			int count=0;
			for(int k=0;k<n;k++) {
				for(int j=0;j<n;j++) {
					if(arr[k][j]==i) {
						count++;
					}
				}
			}
			s[idx++]=count;
		}
		Arrays.sort(s);
		for(int i=0;i<idx;i++) {
			bw.write(String.valueOf(s[i]));
			bw.newLine();
		}
		
		
		bw.close();
		br.close();
	}
}

class Pair{
	int c;
	int r;
	Pair(int c,int r){
		this.c=c;
		this.r=r;
	}
}