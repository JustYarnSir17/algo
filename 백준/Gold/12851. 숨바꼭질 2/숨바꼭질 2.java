import java.io.*;
import java.util.*;

public class Main {
	static int MAX= 100000;
	static int n;
	static int k;
	static int cnt=0;
	static int time=MAX;
	static int [] v= new int[MAX+1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer (br.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        Arrays.fill(v,-1);
        find();
        bw.write(time+"\n"+cnt);
        bw.close();
        br.close();
            
    }
    
    public static void find() {
    	Queue<Node> q= new LinkedList<>();
    	q.offer(new Node(n,0));
    	v[n]=0;
    	while(!q.isEmpty()) {
    		Node curr=q.poll();
    		int p=curr.pos;
    		int t=curr.t;
    		if(p==k) {
    			if (time == MAX) {
                    time = t;
                }
                if (time == t) {
                    cnt++;
                }
                continue;
    		}
    		if(t<time) {
    			if(p*2<=MAX&&(v[p*2]==-1||v[p*2]>=t+1)) {
    				v[p*2]=t+1;
    				q.offer(new Node(p*2,t+1));
    			}
    			if(p+1<=MAX&&(v[p+1]==-1||v[p+1]>=t+1)) {
    				v[p+1]=t+1;
    				q.offer(new Node(p+1,t+1));
    			}
    			if(p-1>=0&&(v[p-1]==-1||v[p-1]>=t+1)) {
    				v[p-1]=t+1;
    				q.offer(new Node(p-1,t+1));
    			}
    		}
    	}
    	
    	
    }
        
}

class Node{
	int pos;
	int t;
	Node(int pos, int t){
		this.pos=pos;
		this.t=t;
	}
}