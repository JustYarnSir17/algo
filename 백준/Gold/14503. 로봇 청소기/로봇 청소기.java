import java.io.*;
import java.util.*;


public class Main {
	static int n,m;
	static int [][] arr;
	static int cnt=0;
	static Node start;
	//방향 d 0은 북쪽, 1은 동쪽, 2는 남쪽, 3은 서쪽 
	static int [] dr = {-1,0,1,0};
	static int [] dc = {0,1,0,-1};
	static boolean tr =false;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int [n][m];
        st=new StringTokenizer(br.readLine());
        start=new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<m;j++) {
        		int tmp = Integer.parseInt(st.nextToken());
        		arr[i][j]=tmp;
        	}
        }
        clean(start);
        bw.write(cnt+"");
        bw.close();
        br.close();
	}
	
	public static void clean(Node curr) {
		if(tr) {
			return;
		}
		//현재 칸 청소
		if(arr[curr.r][curr.c]==0) {
			arr[curr.r][curr.c]=2;
			cnt++;
		}
		//주위 청소 빈 칸 있을 경우
		for(int i=curr.dir-1;i>curr.dir-5;i--) {
			int idx = (4+i)%4;//반시계 방향 
			int nr = curr.r+dr[idx];
			int nc = curr.c+dc[idx];
			if(nr<0||nr>=n||nc<0||nc>=m)
				continue;
			if(arr[nr][nc]==0) {
				clean(new Node(nr,nc,idx));
			}
		}
		//주위 청소 빈 칸이 없을 경우에는 여기 도달
		int idx = (curr.dir+2)%4;
		int nr = curr.r+dr[idx];
		int nc = curr.c+dc[idx];
		if(arr[nr][nc]!=1) {
			clean(new Node(nr,nc,curr.dir));
		}
		
		tr=true;
		return;
		
	}
}

class Node{
	int r;
	int c;
	int dir;
	Node(int r, int c, int dir){
		this.r=r;
		this.c=c;
		this.dir=dir;
	}
}