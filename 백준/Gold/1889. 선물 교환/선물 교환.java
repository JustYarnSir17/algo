import java.io.*;
import java.util.*;



public class Main {
	static int n;
	static int [] indegree;
	static List<List<Integer>> list;
	static boolean [] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        indegree= new int[n+1];
        v=new boolean[n+1];
        list=new ArrayList<>();
        for(int i=0;i<=n;i++) {
        	list.add(new ArrayList<>());
        }
        for(int i=1;i<=n;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken());
        	int b=Integer.parseInt(st.nextToken());
        	indegree[a]++;
        	indegree[b]++;
        	list.get(i).add(a);
        	list.get(i).add(b);
        	
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++) {
        	if(indegree[i]<2) {
        		q.add(i);
        	}
        }
        
        while(!q.isEmpty()) {
        	int curr =  q.poll();
        	if(v[curr])continue;
        	v[curr]=true;
        	
        	for(int num:list.get(curr)) {
        		if(--indegree[num]<2) {
        			q.add(num);
        		}
        	}
        }
        StringBuilder sb = new StringBuilder();
        int cnt=0;
        for(int i=1;i<=n;i++) {
        	if(indegree[i]==2) {
        		cnt++;
        		sb.append(i+" ");
        	}
        }
        bw.write(cnt+"\n");
        bw.write(sb.toString());
        bw.close();
        br.close();
        
	}
    
}