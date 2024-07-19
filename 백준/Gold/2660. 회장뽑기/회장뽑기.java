import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int [] score;
    static List<List<Integer>> list;
    static int answer=51;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n=Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        score=new int[n];
        for(int i=0;i<n;i++) {
        	list.add(new ArrayList<>());
        	
        }
        
        StringTokenizer st =new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        while(a!=-1&&b!=-1) {
        	list.get(a-1).add(b-1);
        	list.get(b-1).add(a-1);
        	st= new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n;i++) {
        	find(i);
        }
        int count=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
        	if(score[i]==answer) {
        		++count;
        		sb.append((i+1)+" ");
        	}
        }
        
        bw.write(answer+" "+count+"\n");
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    
    public static void find(int x) {
    	int [] v= new int[n];
    	v[x]=-1;
    	Queue<Integer> q= new LinkedList<>();
    	q.offer(x);
    	int cnt=0;
    	
    	while(!q.isEmpty()) {
    		int size=q.size();
    		cnt++;
    		for(int k=0;k<size;k++) {
    			int curr=q.poll();
    			for(int i=0;i<list.get(curr).size();i++) {
    				int tmp = list.get(curr).get(i);
    				if(v[tmp]==0) {
    					v[tmp]=cnt;
    					q.offer(tmp);
    				}
    			}
    		}
    		
    	}
    	int m=0;
    	for(int i=0;i<n;i++) {
    		m=Math.max(m,v[i]);
    	}
    	score[x]=m;
    	answer=Math.min(answer,m);
    	
    }
}