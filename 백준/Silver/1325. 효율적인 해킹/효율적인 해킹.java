import java.io.*;
import java.util.*;


public class Main {
	static int n,m;
	static List<List<Integer>>list=new ArrayList<>();
	static int [] arr;
	static int com=0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr= new int [n+1];
        for(int i=0;i<=n;i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++) {
        	st=new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	list.get(b).add(a);
        }
        
        for(int i=1;i<=n;i++) {
        	Queue<Integer> q = new LinkedList<>();
    		boolean[]v=new boolean[n+1];
    		q.offer(i);
    		v[i]=true;
    		
    		int cnt=1;
    		
    		while(!q.isEmpty()) {
    			int curr= q.poll();
    			for(int j=0;j<list.get(curr).size();j++) {
    				int next = list.get(curr).get(j);
    				if(!v[next]) {
    					v[next]=true;
    					cnt++;
    					q.offer(next);
    				}
    				
    			}
    		}
    		arr[i]=cnt;
    		com=Math.max(cnt,com);
        }
        for(int i=1;i<=n;i++) {
        	if(arr[i]==com) {
        		bw.write(i+" ");
        	}
        }
        bw.close();
        br.close();
        
        

	}
	
}