import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static int [][]arr;
	static int time=0;
	static int cnt=0;
	static int [] dr= {1,-1,0,0};
	static int [] dc = {0,0,1,-1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr= new int [n][m];
        for(int i=0;i<n;i++) {
        	st= new StringTokenizer(br.readLine());
        	for(int j=0;j<m;j++) {
        		int tmp =Integer.parseInt(st.nextToken());
        		if(tmp==1) {
        			cnt++;
        		}
        		arr[i][j]=tmp;
        	}
        }
        int time=0;
        while(cnt>0) {
        	find();
        	time++;
        }
        
        bw.write(time+"");
        br.close();
        bw.close();
    }
    
    static void find() {
    	Queue<Node> q= new LinkedList<>();
    	int [][] count = new int [n][m];
    	boolean[][]v= new boolean[n][m];
    	q.offer(new Node(0,0));
    	v[0][0]=true;
    	while(!q.isEmpty()) {
    		Node tmp = q.poll();
    		for(int i=0;i<4;i++) {
    			int nr = tmp.r+dr[i];
    			int nc=tmp.c+dc[i];
    			if(nr<0||nr>=n||nc<0||nc>=m) {
    				continue;
    			}
    			if(arr[nr][nc]==0&&!v[nr][nc]) {
    				v[nr][nc]=true;
    				q.offer(new Node(nr,nc));
    			}
    			else if(arr[nr][nc]==1) {
    				count[nr][nc]++;
    			}
    		}
    	}
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			if(count[i][j]>=2) {
    				arr[i][j]=0;
    				cnt--;
    			}
    		}
    	}
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