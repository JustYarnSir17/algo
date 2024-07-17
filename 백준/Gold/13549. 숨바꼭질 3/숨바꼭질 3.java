import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 100000;
	
	static class Node{
		int pos;
		int time;
		Node(int pos,int time){
			this.pos=pos;
			this.time=time;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int k =Integer.parseInt(st.nextToken());
        
        int answer= find(n,k);
        
        bw.write(answer+"");
        bw.close();
        br.close();
        

    }
    
    public static int find(int n, int k) {
    	int [] v= new int [MAX+1];
    	Arrays.fill(v,-1);
    	Deque<Node> dq = new ArrayDeque<>();
    	
    	dq.add(new Node(n,0));
    	v[n]=0;
    	
    	while(!dq.isEmpty()) {
    		Node curr= dq.poll();
    		int pos = curr.pos;
    		int time= curr.time;
    		
    		if(pos==k) {
    			return time;
    		}
    		
    		if(pos*2<=MAX&&v[pos*2]==-1) {
    			v[pos*2]=time;
    			dq.addFirst(new Node(pos*2,time));
    		}
    		if(pos-1>=0&&v[pos-1]==-1) {
    			v[pos-1]=time+1;
    			dq.addLast(new Node(pos-1,time+1));
    		}
    		
    		if(pos+1<=MAX&&v[pos+1]==-1) {
    			v[pos+1]=time+1;
    			dq.addLast(new Node(pos+1,time+1));
    		}
    	}
    return -1;	
    }
}