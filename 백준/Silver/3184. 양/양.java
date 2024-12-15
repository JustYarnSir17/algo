import java.io.*;
import java.util.*;

public class Main {
	static int r,c;
	static char[][]arr;
	static boolean[][]v;
	static int [] dr= {1,0,-1,0};
	static int [] dc= {0,1,0,-1};
	
	static int sheep=0,wolf=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr=new char[r][c];
        v=new boolean[r][c];
        for(int i=0;i<r;i++) {
        	String str= br.readLine();
        	for(int j=0;j<c;j++) {
        		arr[i][j]=str.charAt(j);
        	}
        }
        
        find();
        bw.write(sheep+" "+wolf);
        bw.close();
        br.close();
	}
    
    public static void find() {
    	for(int i=0;i<r;i++) {
    		for(int j=0;j<c;j++) {
    			if(!v[i][j]&&arr[i][j]!='#') {
    				find(i,j);
    			}
    		}
    	}
    }
    
    public static void find(int x, int y) {
    	Queue<int[]>q = new LinkedList<>();
    	q.offer(new int[] {x,y});
    	v[x][y]=true;
    	
    	int s=0;
    	int w=0;
    	if(arr[x][y]=='o') {
    		s++;
    	}
    	else if(arr[x][y]=='v') {
    		w++;
    	}
    	while(!q.isEmpty()) {
    		int [] curr=q.poll();
    		for(int i=0;i<4;i++) {
    			int nr= curr[0]+dr[i];
    			int nc=curr[1]+dc[i];
    			if(nr<0||nr>=r||nc<0||nc>=c) {
    				continue;
    			}
    			if(!v[nr][nc]&&arr[nr][nc]=='.') {
    				v[nr][nc]=true;
    				q.offer(new int[] {nr,nc});
    			}
    			else if(!v[nr][nc]&&arr[nr][nc]=='v') {
    				w++;
    				v[nr][nc]=true;
    				q.offer(new int[] {nr,nc});
    			}
    			else if(!v[nr][nc]&&arr[nr][nc]=='o') {
    				s++;
    				v[nr][nc]=true;
    				q.offer(new int[] {nr,nc});
    			}
    		}
    		
    	}
    	if(w>=s) {
    		wolf+=w;
    	}
    	else {
    		sheep+=s;
    	}
    	
    }
}