import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static int [][] arr;
	static Node start;
	static int [] dr= {1,-1,0,0};
	static int [] dc= {0,0,1,-1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        
        arr=new int[n][m];
        for(int i=0;i<n;i++) {
        	String str= br.readLine();
        	for(int j=0;j<m;j++) {//#은 3 *은 2
        		if(str.charAt(j)=='#') {
        			arr[i][j]=3;
        		}
        		else if(str.charAt(j)=='*') {
        			arr[i][j]=2;
        			start=new Node(i,j);
        		}
        		else {
        			arr[i][j]=str.charAt(j)-'0';
        		}
        	}
        }
        boolean tr=true;
        int cnt=0;
        while(tr) {
        	++cnt;
        	tr=find();
        	
        }
        bw.write(cnt+"");
        bw.close();
        br.close();
        
    }
    public static boolean find() {
    	Queue<Node> q = new LinkedList<>();
    	boolean[][]v=new boolean[n][m];
    	q.offer(new Node(start.r,start.c));
    	v[start.r][start.c]=true;
    	while(!q.isEmpty()) {
    		Node curr = q.poll();
    		for(int i=0;i<4;i++) {
    			int nr= curr.r+dr[i];
    			int nc= curr.c+dc[i];
    			if(nr<0||nr>=n||nc<0||nc>=m) {
    				continue;
    			}
    			if(!v[nr][nc]) {
    				if(arr[nr][nc]==0) {
    					v[nr][nc]=true;
    					q.offer(new Node(nr,nc));
    				}
    				else if(arr[nr][nc]==1) {
    					v[nr][nc]=true;
    					arr[nr][nc]=0;
    					
    				}
    				else if(arr[nr][nc]==3){
    					return false;
    				}
    				
    			}
    		}
    	}
    	return true;
    }
    
}


class Node{
	int r;
	int c;
	Node(int r,int c){
		this.r=r;
		this.c=c;
	}
}