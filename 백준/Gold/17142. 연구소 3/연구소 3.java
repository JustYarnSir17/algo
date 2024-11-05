import java.io.*;
import java.util.*;


public class Main {
	static int n,m;
	static int [][]arr;
	static List<int[]>list = new ArrayList<>();
	static int time =Integer.MAX_VALUE;
	static Stack<Integer> stack = new Stack<>();
	static int [] dr = {1,0,-1,0};
	static int [] dc = {0,1,0,-1};
	static int zero =0;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n=Integer.parseInt(st.nextToken());
    	m=Integer.parseInt(st.nextToken());
    	arr= new int [n][n];
    	for(int i=0;i<n;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<n;j++) {
    			arr[i][j]=Integer.parseInt(st.nextToken());
    			if(arr[i][j]==2) {
    				list.add(new int[] {i,j});
    			}
    			else if(arr[i][j]==0) {
    				zero++;
    			}
    		}
    	}
    	find(0,0);
    	if(time==Integer.MAX_VALUE) {
    		bw.write("-1");
    	}
    	else {
    		bw.write(String.valueOf(time));
    		
    	}
    	bw.close();
    	br.close();
    }
    
    public static void find(int cnt,int idx) {
    	if(cnt==m) {
    		Queue<Node> q= new LinkedList<>();
    		for(int num:stack) {
    			int [] tmp = list.get(num);
    			q.offer(new Node(tmp[0],tmp[1]));
    		}
    		search(q);
    		return;
    	}
    	for(int i=idx;i<list.size();i++) {
    		stack.push(i);
    		find(cnt+1,i+1);
    		stack.pop();
    		
    	}
    }
    
    public static void search(Queue<Node>q) {
    	int[][]v = new int[n][n];
    	for(int i=0;i<n;i++) {
    		Arrays.fill(v[i],Integer.MAX_VALUE);
    	}
    	int count= 0;
    	int virus=0;
    	for(Node curr:q) {
    		v[curr.r][curr.c]=0;
    	}
    	while(!q.isEmpty()) {
    		Node curr = q.poll();
    		for(int i=0;i<4;i++) {
    			int nr = curr.r+dr[i];
    			int nc = curr.c+dc[i];
    			if(nr<0||nr>=n||nc<0||nc>=n)
    				continue;
    			if(v[nr][nc]>v[curr.r][curr.c]+1&&arr[nr][nc]==0) {
    				v[nr][nc]=v[curr.r][curr.c]+1;
    				virus++;
    				q.offer(new Node(nr,nc));
    			}
    			else if(v[nr][nc]>v[curr.r][curr.c]+1&&arr[nr][nc]==2) {
    				v[nr][nc]=v[curr.r][curr.c]+1;
    				q.offer(new Node(nr,nc));
    			}
    		}
    	}
    	if(virus==zero) {
    		for(int i=0;i<n;i++) {
    			for(int j=0;j<n;j++) {
    				if(arr[i][j]==0) {
    					count=Math.max(count,v[i][j]);
    					
    				}
    			}
    		}
    		time=Math.min(time,count);
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