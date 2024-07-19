import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean[]v;
    static List<List<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n=Integer.parseInt(br.readLine());
        v=new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        list=new ArrayList<>();
        for(int i=0;i<n;i++) {
        	list.add(new ArrayList<>());
        	
        }
        int x=Integer.parseInt(st.nextToken())-1;
        int y=Integer.parseInt(st.nextToken())-1;
        int m=Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++) {
        	st=new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken())-1;
        	int b=Integer.parseInt(st.nextToken())-1;
        	list.get(a).add(b);
        	list.get(b).add(a);
        }
        
        int answer=find(x,y);
        bw.write(answer+"");
        bw.close();
        br.close();
    }
    
    
    public static int find(int a, int b) {
    	Queue<Integer> q=new LinkedList<>();
    	q.offer(a);
    	v[a]=true;
    	int cnt=0;
    	while(!q.isEmpty()) {
    		int size=q.size();
    		
    		for(int k=0;k<size;k++) {
    			int curr=  q.poll();
        		if(curr==b)
        			return cnt;
        		
        		for(int i=0;i<list.get(curr).size();i++) {
        			int tmp = list.get(curr).get(i);
        			
        			if(!v[tmp]) {
        				v[tmp]=true;
        				q.offer(tmp);
        			}
        		}
    		}
    		cnt++;
    		
    	}
    	return -1;
    }
}