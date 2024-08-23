import java.io.*;
import java.util.*;

public class Main {
	static int root;
	static List<List<Integer>> list;
	static int cnt=0;
	static boolean[] v;
	static int del;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        
        int n=Integer.parseInt(br.readLine());
        v=new boolean[n];
        list = new ArrayList<>();
        for(int i=0;i<n;i++) {
        	list.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        root=0;
        for(int i=0;i<n;i++) {
        	int tmp =Integer.parseInt(st.nextToken());
        	if(tmp==-1) {
        		root=i;
        		continue;
        	}
        	list.get(tmp).add(i);
        }
        del=Integer.parseInt(br.readLine());
        if(del!=root) {
        list.get(del).clear();
        find();
        }
        
        bw.write(cnt+"");
        bw.close();
        br.close();
        
    }
    
    public static void find() {
    	Queue<Integer> q= new LinkedList<>();
    	q.offer(root);
    	v[root]=true;
    	while(!q.isEmpty()) {
    		int tmp = q.poll();
    		if(list.get(tmp).size()==0) {
    			cnt++;
    			continue;
    		}
    		else if(list.get(tmp).size()==1&&list.get(tmp).get(0)==del) {
    			cnt++;
    			continue;
    		}
    		for(int i=0;i<list.get(tmp).size();i++) {
    			int next =list.get(tmp).get(i);
    			if(!v[next]&&next!=del) {
    				v[next]=true;
    				q.offer(next);
    			}
    		}
    	}
    }
    
    
}