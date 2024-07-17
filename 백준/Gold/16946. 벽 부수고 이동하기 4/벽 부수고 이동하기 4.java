import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static int [][] arr;
	static int [] dr= {1,-1,0,0};
	static int [] dc= {0,0,1,-1};
	static int [][] cnt;
	static boolean[][] v;
	static int [][] group;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr= new int[n][m];
        cnt= new int[n][m];
        v=new boolean[n][m];
        group= new int[n][m];
        for(int i=0;i<n;i++) {
        	String tmp = br.readLine();
        	for(int j=0;j<m;j++) {
        		arr[i][j]=tmp.charAt(j)-'0';
        	}
        	
        }
        
        find();
        for(int i=0;i<n;i++) {
        	for(int j=0;j<m;j++) {
        		if(arr[i][j]==1) {
        			int sum=0;
        			Set<Integer>set= new HashSet<>();
        			for(int k=0;k<4;k++) {
        				int nr = i+dr[k];
        				int nc = j+dc[k];
        				if(nr<0||nr>=n||nc<0||nc>=m)
        					continue;
        				if(arr[nr][nc]==0&&set.add(group[nr][nc])) {
        					sum+=cnt[nr][nc];
        				}
        			}
        			arr[i][j]=(sum+1)%10;
        		}
        	}
        }
        
        
        for(int i=0;i<n;i++) {
        	for(int j=0;j<m;j++) {
        		bw.write(String.valueOf(arr[i][j]));
        		
        	}
        	bw.newLine();
        }
        bw.close();
        br.close();
        
    }
    
    public static void find() {
    	int groupId=1;
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			if(arr[i][j]==0&&!v[i][j]) {
    				bfs(i,j,groupId++);
    			}
    		}
    	}
    }
    
    public static void bfs(int r,int c,int groupId) {
    	
    	Queue<Node> q = new LinkedList<>();
    	List<Node> list = new ArrayList<>();
    	int count=1;
    	q.offer(new Node(r,c));
    	v[r][c]=true;
    	group[r][c]=groupId;
    	list.add(new Node(r,c));
    	while(!q.isEmpty()) {
    		Node curr = q.poll();
    		for(int i=0;i<4;i++) {
    			int nr= curr.r+dr[i];
    			int nc= curr.c+dc[i];
    			if(nr<0||nr>=n||nc<0||nc>=m) {
    				continue;
    			}
    			if(arr[nr][nc]==0&&!v[nr][nc]) {
    				count++;
    				v[nr][nc]=true;
    				q.offer(new Node(nr,nc));
    				list.add(new Node(nr,nc));
    				group[nr][nc]=groupId;
    			}
    		}
    	}
    	for(int i=0;i<list.size();i++) {
    		Node tmp = list.get(i);
    		cnt[tmp.r][tmp.c]=count;
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