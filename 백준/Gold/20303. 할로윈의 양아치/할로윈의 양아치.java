import java.io.*;
import java.util.*;


public class Main {
	static int n,m,k;
	static int [] p;
	static int [] candy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n =Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken());
        k =Integer.parseInt(st.nextToken());
        p=new int[n];
        st=new StringTokenizer(br.readLine());
        candy=new int[n];
        
        for(int i=0;i<n;i++) {
        	candy[i]=Integer.parseInt(st.nextToken());
        	p[i]=i;
        }
        
        for(int i=0;i<m;i++) {
        	st=new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken())-1;
        	int b = Integer.parseInt(st.nextToken())-1;
        	
        	union(a,b);
        }
        
        HashMap<Integer,Integer> map= new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        int idx=0;
        for(int i=0;i<n;i++) {
        	int root=find(i);
        	if(!map.containsKey(root)) {
        		map.put(root,idx++);
        		list.add(new ArrayList<>());
        	}
        	list.get(map.get(root)).add(candy[i]);
        }
        
        int [][] c= new int [list.size()][2];
        
        for(int i=0;i<list.size();i++) {
        	int sum=0;
        	for(int j=0;j<list.get(i).size();j++) {
        		sum+=list.get(i).get(j);
        	}
        	c[i][0]=list.get(i).size();
        	c[i][1]=sum;
        }
        int [][] dp = new int [c.length+1][k];
        for(int i=1;i<=c.length;i++) {
        	for(int j=0;j<k;j++) {
        		dp[i][j]=dp[i-1][j];
        		if(j-c[i-1][0]>=0) {
        			dp[i][j]=Math.max(dp[i][j],dp[i-1][j-c[i-1][0]]+c[i-1][1]);
        		}
        	}
        }
        int maxScore=0;
        for(int i=0;i<=c.length;i++) {
        	for(int j=0;j<k;j++) {
        		maxScore=Math.max(maxScore,dp[i][j]);
        	}
        }
        bw.write(String.valueOf(maxScore));
        bw.close();
        br.close();
    }
    
    
    
    public static int find(int a) {
    	if(p[a]!=a) {
    		p[a]=find(p[a]);
    	}
    	return p[a];
    }
    
    public static void union(int a, int b) {
    	int rootA = find(a);
    	int rootB = find(b);
    	if(rootA!=rootB) {
    		p[rootB]=rootA;
    	}
    }
    
}