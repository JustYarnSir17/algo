import java.io.*;
import java.util.*;


public class Main {
	static int n,m;
	static HashMap<Integer, Integer> map=new HashMap<>();
	static boolean []v=new boolean[101];
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++) {
        	st= new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	map.put(a,b);
        }
        for(int i=0;i<m;i++) {
        	st= new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	map.put(a,b);
        }
        
        int answer= find();
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
       
    }
    public static int find() {
    	Queue<Integer> q= new LinkedList<>();
    	q.offer(1);
    	v[1]=true;
    	int cnt=0;
    	while(!q.isEmpty()) {
    		int size=q.size();
    		cnt++;
    		for(int i=0;i<size;i++) {
    			int curr = q.poll();
    			
    			for(int j =1;j<=6;j++) {
    				int next = curr+j;
    				if(next==100) {
    					return cnt;
    				}
    				if(!v[next]) {
    					v[next]=true;
    					if(map.containsKey(next)) {
    						v[map.get(next)]=true;
    						q.offer(map.get(next));
    					}
    					else {
    						q.offer(next);
    					}
    				}
    			}
    		}
    	}
    	return cnt;
    }
    
}