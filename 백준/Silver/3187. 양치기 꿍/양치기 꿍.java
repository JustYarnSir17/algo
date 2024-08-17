import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w=0;
        int s=0;
        char [][] arr= new char [r][c];
        boolean [][] v= new boolean[r][c];
        for(int i=0;i<r;i++) {
        	String str = br.readLine();
        	for(int j=0;j<c;j++) {
        		arr[i][j]=str.charAt(j);
        		
        	}
        }
        
        for(int i=0;i<r;i++) {
        	for(int j=0;j<c;j++) {
        		if(arr[i][j]!='#'&&!v[i][j]) {
        			int [] answer=find(arr,v,i,j);
        			s+=answer[0];
        			w+=answer[1];
        		}
        	}
        }
        
        bw.write(s+" "+w);
        bw.close();
        br.close();
        
    }
    
    public static int [] find(char[][] arr, boolean[][] v,int r,int c) {
    	int []answer = new int[2];//양, 늑대
    	int [] dr= {1,-1,0,0};
    	int [] dc = {0,0,1,-1};
    	
    	Queue<Node> q= new LinkedList<>();
    	if(arr[r][c]=='v') {//늑대
    		answer[1]++;
    	}
    	else if(arr[r][c]=='k') {//양
    		answer[0]++;
    	}
    	v[r][c]=true;
    	q.offer(new Node(r,c));
    	while(!q.isEmpty()) {
    		Node tmp = q.poll();
    		for(int i=0;i<4;i++) {
    			int nr = tmp.r+dr[i];
    			int nc = tmp.c+dc[i];
    			if(nr<0||nr>=arr.length||nc<0||nc>=arr[0].length) {
    				continue;
    			}
    			if(arr[nr][nc]=='.'&&!v[nr][nc]) {
    				v[nr][nc]=true;
    				q.offer(new Node(nr,nc));
    			}
    			else if(arr[nr][nc]=='v'&&!v[nr][nc]) {//늑대
    				v[nr][nc]=true;
    				answer[1]++;
    				q.offer(new Node(nr,nc));
    			}
    			else if(arr[nr][nc]=='k'&&!v[nr][nc]) {//양
    				v[nr][nc]=true;
    				answer[0]++;
    				q.offer(new Node(nr,nc));
    			}
    		}
    	}
    	if(answer[0]>answer[1]) {
    		answer[1]=0;
    	}
    	else {
    		answer[0]=0;
    	}
    	
    	return answer;
    }
   
}

class Node{
	int r;
	int c;
	Node(int r, int c){
		this.r=r;
		this.c=c;
	}
}