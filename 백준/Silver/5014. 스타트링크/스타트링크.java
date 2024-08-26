import java.io.*;
import java.util.*;

public class Main {
	static int cnt=Integer.MAX_VALUE;
	static int g;
	static int f;
	static int s;
	static int u;
	static int d;
	static boolean[]v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        f= Integer.parseInt(st.nextToken());
        s= Integer.parseInt(st.nextToken());
        g= Integer.parseInt(st.nextToken());
        u= Integer.parseInt(st.nextToken());
        d= Integer.parseInt(st.nextToken());
        v=new boolean[f+1];
        find();
        if(cnt==Integer.MAX_VALUE) {
        	bw.write("use the stairs");
        }
        else{
        	bw.write(cnt+"");
        }
        
        bw.close();
        br.close();
        
    }
    
    public static void find() {
    	Queue<Integer> q= new LinkedList<>();
    	v[s]=true;
    	q.offer(s);
    	int count=-1;
    	while(!q.isEmpty()) {
    		int size=q.size();
    		count++;
    		for(int i=0;i<size;i++) {
    			int curr= q.poll();
    			if(curr==g) {
    				cnt=count;
    				return;
    			}
    			if(curr+u<=f&&!v[curr+u]) {
    				v[curr+u]=true;
    				q.offer(curr+u);
    				
    			}
    			if(curr-d>0&&!v[curr-d]) {
    				v[curr-d]=true;
    				q.offer(curr-d);
    			}
    			
    		}
    		
    	}
    	
    	
    }
}