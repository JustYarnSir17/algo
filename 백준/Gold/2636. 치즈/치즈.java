import java.io.*;
import java.util.*;


public class Main {
	static int n,m;
	static int [][] arr;
	static int time=0;
	static int amount=0;
	static int last=0;
	static int [] dr= {0,0,1,-1};
	static int [] dc= {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st= new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int [n][m];
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<m;j++) {
        		int tmp =Integer.parseInt(st.nextToken());
        		arr[i][j]=tmp;
        		if(tmp==1) {
        			amount++;
        		}
        	}
        }
        while(amount!=0) {
        	time++;
        	last=amount;
        	melting();
        }
        bw.write(time+"\n"+last);
        bw.close();
        br.close();
        
	}
	
	public static void melting() {
		Queue<Node> q=new LinkedList<>();
		boolean[][]v =new boolean[n][m];
		q.offer(new Node(0,0));
		v[0][0]=true;
		while(!q.isEmpty()) {
			Node curr= q.poll();
			for(int i=0;i<4;i++) {
				int nr = curr.r+dr[i];
				int nc = curr.c+dc[i];
				if(nr<0||nr>=n||nc<0||nc>=m)
					continue;
				if(!v[nr][nc]) {
					if(arr[nr][nc]==0) {
						v[nr][nc]=true;
						q.offer(new Node(nr,nc));
					}
					else if(arr[nr][nc]==1) {
						v[nr][nc]=true;
						arr[nr][nc]=0;
						amount--;
					}
				}
			}
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