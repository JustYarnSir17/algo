import java.io.*;
import java.util.*;


public class Main {
	static int n,m;
	static int [][]arr;
	static int [][] answer;
	static int [] dr= {1,-1,0,0};
	static int [] dc = {0,0,1,-1};
	
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n][m];
        answer= new int [n][m];
        Node start=new Node(0,0);
        for(int i=0;i<n;i++) {
        	Arrays.fill(answer[i],Integer.MAX_VALUE);
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<m;j++) {
        		int tmp = Integer.parseInt(st.nextToken());
        		arr[i][j]=tmp;
        		if(tmp==2) {
        			start=new Node(i,j);
        		}
        		
        	}
        }
        find(start);
        for(int i=0;i<n;i++) {
        	for(int j=0;j<m;j++) {
        		bw.write(answer[i][j]+" ");
        	}
        	bw.newLine();
        }
        bw.close();
        br.close();
	}
	
	public static void find(Node start) {
		Queue<Node> q= new LinkedList<>();
		q.offer(new Node(start.r,start.c));
		answer[start.r][start.c]=0;
		while(!q.isEmpty()) {
			Node curr= q.poll();
			for(int i=0;i<4;i++) {
				int nr = curr.r+dr[i];
				int nc = curr.c+dc[i];
				if(nr<0||nr>=n||nc<0||nc>=m)
					continue;
				if(arr[nr][nc]!=0&&answer[nr][nc]>answer[curr.r][curr.c]+1) {
					answer[nr][nc]=answer[curr.r][curr.c]+1;
					q.offer(new Node(nr,nc));
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0) {
					answer[i][j]=0;
				}
				if(answer[i][j]==Integer.MAX_VALUE) {
					answer[i][j]=-1;
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