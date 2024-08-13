import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static int [][]Arr;
	static List<Node> list = new ArrayList<>();
	static int count=Integer.MAX_VALUE;
	static Stack<Node>stack = new Stack<>();
	
	static int [] dr= {-1,1,0,0};
	static int [] dc= {0,0,-1,1};
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n =Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken());
        
        Arr= new int [n][n];
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<n;j++) {
        		int tmp = Integer.parseInt(st.nextToken());
        		Arr[i][j]=tmp;
        		if(tmp==2) {
        			list.add(new Node(i,j));
        		}
        	}
        }
        find(0,0);
        if(count==Integer.MAX_VALUE) {
        	bw.write("-1");
        }
        else {
        bw.write(count+"");
        }
        bw.close();
        br.close();
        
    }
    
    public static void find(int idx,int virus) {
    	if(virus==m) {
    		bfs();
    		return;
    	}
    	for(int i=idx;i<list.size();i++) {
    		stack.push(list.get(i));
    		find(i+1,virus+1);
    		stack.pop();
    		
    	}
    }
    
    public static void bfs() {
    	Queue<Node> q= new LinkedList<>();
    	boolean[][] v= new boolean[n][n];
    	for(Node node:stack) {
    		q.offer(node);
    		v[node.r][node.c]=true;
    	}
    	int [][] arr =new int [n][n];
    	for(int i=0;i<n;i++) {
    		arr[i]=Arrays.copyOf(Arr[i],n);
    	}
    	int cnt=0;
    	while(!q.isEmpty()) {
    		int size = q.size();
    		cnt++;
    		for(int s=0;s<size;s++) {
    			Node curr= q.poll();
    			for(int i=0;i<4;i++) {
    				int nr= curr.r+dr[i];
    				int nc=curr.c+dc[i];
    				if(nr<0||nr>=n||nc<0||nc>=n)
    					continue;
    				if((arr[nr][nc]==0||arr[nr][nc]==2)&&!v[nr][nc]) {
    					v[nr][nc]=true;
    					arr[nr][nc]=cnt;
    					q.offer(new Node(nr,nc));
    				}
    			}
    		}
    	}
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			if((arr[i][j]==0||arr[i][j]==2)&&!v[i][j]) {
    				return;
    			}
    		}
    	}
    	count=Math.min(cnt-1,count);
    	return;
    }
}

class Node{
	int r;
	int c;
	Node(int r, int c ){
		this.r=r;
		this.c=c;
	}
	
}