import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t=Integer.parseInt(br.readLine());
        for(int time=0;time<t;time++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int n=Integer.parseInt(st.nextToken());
        	int m=Integer.parseInt(st.nextToken());
        	int [] dr= {1,0,-1,0};
        	int [] dc= {0,1,0,-1};
        	char [][] arr = new char[n][m];
        	boolean [][]v=new boolean[n][m];
        	for(int i=0;i<n;i++) {
        		String str =br.readLine();
        		for(int j=0;j<m;j++) {
        			arr[i][j]=str.charAt(j);
        		}
        	}
        	int cnt=0;
        	for(int i=0;i<n;i++) {
        		for(int j=0;j<m;j++) {
        			if(arr[i][j]=='#'&&!v[i][j]) {
        				cnt++;
        				Queue<int[]> q = new LinkedList<>();
        				q.offer(new int[] {i,j});
        				v[i][j]=true;
        				while(!q.isEmpty()) {
        					int[] tmp = q.poll();
        					for(int k=0;k<4;k++) {
        						int nr = tmp[0]+dr[k];
        						int nc = tmp[1]+dc[k];
        						if(nr<0||nr>=n||nc<0||nc>=m)
        							continue;
        						if(arr[nr][nc]=='#'&&!v[nr][nc]) {
        							v[nr][nc]=true;
        							q.offer(new int[] {nr,nc});
        						}
        					}
        				}
        			}
        		}
        	}
        	
        	bw.write(cnt+"\n");
        }
        bw.close();
        br.close();
	}
}