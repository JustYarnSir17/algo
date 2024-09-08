import java.io.*;
import java.util.*;


public class Main {
	static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        HashMap <String,Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n =Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++) {
        	String str = br.readLine();
        	if(str.length()>=m) {
        		if(!set.contains(str)) {
        			set.add(str);
        			map.put(str,1);
        		}
        		else {
        			map.replace(str,map.get(str)+1);
        		}
        	}
        }
        for(String str :set) {
        	int cnt= map.get(str);
        	pq.offer(new Node(str,cnt));
        }
        
        while(!pq.isEmpty()) {
        	Node tmp = pq.poll();
        	bw.write(tmp.str+"\n");
        }
        bw.close();
        br.close();
	}
}

class Node implements Comparable<Node>{
	String str;
	int cnt;
	Node(String str, int cnt){
		this.str=str;
		this.cnt=cnt;
	}
	
	@Override
	public int compareTo(Node o) {
		if(this.cnt==o.cnt) {
			if(this.str.length()==o.str.length()) {
				return this.str.compareTo(o.str);
			}
			else {
				return o.str.length()-this.str.length();
			}
		}
		else {
			return o.cnt-this.cnt;
		}
	}
	
}