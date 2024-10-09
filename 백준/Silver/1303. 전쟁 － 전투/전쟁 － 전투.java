import java.io.*;
import java.util.*;


public class Main {
	static int n,m;
	static char [][] arr;
	static boolean[][] v;
	static int w,b;
	static int [] dr = {1,0,-1,0};
	static int [] dc = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new char[m][n];
        v= new boolean[m][n];
        for(int i=0;i<m;i++) {
        	String str = br.readLine();
        	for(int j=0;j<n;j++) {
        		arr[i][j]=str.charAt(j);
        	}
        	
        }
        
        for(int i=0;i<m;i++) {
        	for(int j=0;j<n;j++) {
        		if(!v[i][j]) {
        			if(arr[i][j]=='W'){
        				find(i,j,'W');
        			}
        			else {
        				find(i,j,'B');
        			}
        		}
        	}
        }
        
        bw.write(w+" "+b);
        bw.close();
        br.close();
	}
	
	public static void find(int r,int c,char team) {
		Queue<int[]> q= new LinkedList<>();
		int cnt=1;
		q.offer(new int[] {r,c});
		v[r][c]=true;
		while(!q.isEmpty()) {
			int[] tmp=q.poll();
			for(int i=0;i<4;i++) {
				int nr =tmp[0]+dr[i];
				int nc = tmp[1]+dc[i];
				if(nr<0||nr>=m||nc<0||nc>=n)
					continue;
				if(!v[nr][nc]&&arr[nr][nc]==team) {
					cnt++;
					v[nr][nc]=true;
					q.offer(new int[] {nr,nc});
				}
			}
		}
		
		if(team=='W') {
			w+=cnt*cnt;
		}
		else {
			b+=cnt*cnt;
		}
		
		
	}
	
}