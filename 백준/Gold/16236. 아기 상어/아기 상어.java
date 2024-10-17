import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int [][]arr;
	static boolean [][]v;
	static Node start;
	static int size = 2;
	static int count=0;
	static int [] dr= {1,0,-1,0};
	static int [] dc = {0,1,0,-1};
	static Queue<Node> q = new LinkedList<>();
	static PriorityQueue<Node>pq= new PriorityQueue<>();
	static int time=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//0은 빈칸, 123456 칸에 있는 물고기 크기, 9는 아기상어 위치
		//더 이상 먹을 수 있는 물고기 없으면 엄마 상어 호출
		//크기가 큰 물고기는 지나갈 수 없고, 나머지는 가능, 크기가 같거나 큰 물고기는 못 먹고, 크기가 작은 물고기만  먹음
		//먹을 수 있는 물고기 1마리 이상, 가장 가까운 물고기
		//거리가 갸까운 물고기가 많다면 가장 위에, 가장 왼쪽 순으로
		n=Integer.parseInt(br.readLine());
		arr=new int [n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				int tmp =Integer.parseInt(st.nextToken());
				arr[i][j]=tmp;
				if(tmp==9) {
					start=new Node(i,j,0);
					
				}
			}
		}
		
		q.offer(start);//시작 
		arr[start.r][start.c]=0;//시작 부분 0
		
		while(!q.isEmpty()) {
			find();//탐색
			if(!pq.isEmpty()) {
				Node next = pq.poll();//가장 우선 순위 먹이를 먹는 걸로
				arr[next.r][next.c]=0;//먹고 났으니 빈칸으로 변환
				q.offer(next);//다음 시작부분은 먹고난 자리
				time=Math.max(time,next.time);//마지막 먹이를 먹었을 때 시간 갱신
				pq=new PriorityQueue<>();//다음 먹이는 해당 자리부터 재 탐색
				count++;//먹이 카운트
				if(count==size) {//만약 먹은 먹이 수가 상어 크기와 같아진다면 성장한다
					size++;
					count=0;
				}
			}
		}
		bw.write(time+"");
		bw.close();
		br.close();
	}
	
	public static void find() {
		v=new boolean[n][n];
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			for(int i=0;i<4;i++) {
				int nr = curr.r+dr[i];
				int nc = curr.c+dc[i];
				if(nr<0||nr>=n||nc<0||nc>=n)
					continue;
				if(arr[nr][nc]==0&&!v[nr][nc]) {//가지 않은 빈칸인 경우
					v[nr][nc]=true;
					q.offer(new Node(nr,nc,curr.time+1));
				}
				else if(arr[nr][nc]!=0&&!v[nr][nc]) {//빈칸인데 물고기가 있는 경우
					if(arr[nr][nc]<size) {//물고기 크기가 작은 경우
						pq.offer(new Node(nr,nc,curr.time+1));//먹이로 선별
						v[nr][nc]=true;
						q.offer(new Node(nr,nc,curr.time+1));//지나가기
					}
					else if(arr[nr][nc]==size) {//크기가 같은 경우
						v[nr][nc]=true;
						q.offer(new Node(nr,nc,curr.time+1));//지나가기만 하기 
					}
					
				}
				
			}
		}
		
	}
}

class Node implements Comparable<Node>{
	int r;
	int c;
	int time;
	Node(int r, int c, int time){
		this.r=r;
		this.c=c;
		this.time=time;
	}
	@Override
	public int compareTo(Node o) {
		if(this.time==o.time) {
			if(this.r==o.r) {
				return this.c-o.c;
			}
			else {
				return this.r-o.r;
			}
		}
		else {
			return this.time-o.time;
		}
	}
	
}