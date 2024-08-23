import java.io.*;
import java.util.*;

public class Main {
	static int r;
	static int c;
	static int [] dr= {1,-1,0,0};
	static int [] dc= {0,0,1,-1};
	static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        
        arr= new char[r][c];
        for(int i=0;i<r;i++) {
        	String str= br.readLine();
        	for(int j=0;j<c;j++) {
        		arr[i][j]=str.charAt(j);
        	}
        }
        island();
        
        int x1=c,x2=0;
        int y1=r,y2=0;
        
        for(int i=0;i<r;i++) {
        	for(int j=0;j<c;j++) {
        		if(arr[i][j]=='X') {
        			if(x1>j) {
        				x1=j;
        			}
        			if(y1>i) {
        				y1=i;
        			}
        			if(x2<j) {
        				x2=j;
        			}
        			if(y2<i) {
        				y2=i;
        			}
        		}
        	}
        }
        for(int i=y1;i<=y2;i++) {
        	for(int j=x1;j<=x2;j++) {
        		bw.write(arr[i][j]);
        	}
        	bw.newLine();
        }
        bw.close();
        br.close();
    }
    
    public static void island() {
    	Stack<Node> stack = new Stack<>();
    	Queue<Node> q= new LinkedList<>();
    	for(int i=0;i<r;i++) {
    		for(int j=0;j<c;j++) {
    			if(arr[i][j]=='X') {
    				q.offer(new Node(i,j));
    			}
    		}
    	}
    	while(!q.isEmpty()) {
    		Node tmp = q.poll();
    		int cnt=0;
    		for(int i=0;i<4;i++) {
    			int nr = tmp.r+dr[i];
    			int nc = tmp.c+dc[i];
    			if(nr<0||nr>=r||nc<0||nc>=c) {
    				cnt++;
    				continue;
    			}
    			if(arr[nr][nc]=='.')
    				cnt++;
    			
    		}
    		if(cnt>=3) {
    			stack.push(new Node(tmp.r,tmp.c));
    		}
    	}
    	
    	while(!stack.isEmpty()) {
    		Node tmp = stack.pop();
    		arr[tmp.r][tmp.c]='.';
    	}
    	
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