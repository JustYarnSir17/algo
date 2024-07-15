import java.io.*;
import java.util.*;

public class Main {
	static List<List<Integer>> adj = new ArrayList<>();
	static boolean[] onStack;
	static int[] ids,low;
	static int id=0;
	static Stack<Integer> stack =  new Stack<>();
	static List<List<Integer>> sccs = new ArrayList<>();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v=Integer.parseInt(st.nextToken());
        int e=Integer.parseInt(st.nextToken());
        for(int i=0;i<v;i++) {
        	adj.add(new ArrayList<>());
        	
        }
        for(int i=0;i<e;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken())-1;
        	int b = Integer.parseInt(st.nextToken())-1;
        	adj.get(a).add(b);
        }
        ids=new int[v];
        low=new int[v];
        onStack = new boolean[v];
        Arrays.fill(ids,-1);
        
        for(int i=0;i<v;i++) {
        	if(ids[i]==-1) {
        		dfs(i);
        	}
        }
        bw.write(sccs.size()+"\n");
        for(int i=0;i<sccs.size();i++) {
        	Collections.sort(sccs.get(i));
        	
        }
        sccs.sort(Comparator.comparingInt(o -> o.get(0)));
        for(List<Integer> scc:sccs) {
        	for(int V: scc) {
        		bw.write((V+1)+" ");
        	}
        	bw.write("-1");
        	bw.newLine();
        }
        bw.close();
        br.close();
    }
    public static void dfs(int at) {
    	stack.push(at);
    	onStack[at]=true;
    	ids[at]=low[at]=id++;
    	
    	for(int to:adj.get(at)) {
    		if(ids[to]==-1) {
    			dfs(to);
    			low[at]=Math.min(low[at],low[to]);
    		}
    		else if(onStack[to]){
    			low[at]= Math.min(low[at],ids[to]);
    		}
    	}
    	if(ids[at]==low[at]) {
    		List<Integer> scc = new ArrayList<>();
    		while(true) {
    			int node=stack.pop();
    			onStack[node]=false;
    			scc.add(node);
    			low[node]=ids[at];
    			if(node==at)break;
    		}
    		sccs.add(scc);
    	}
    }
}