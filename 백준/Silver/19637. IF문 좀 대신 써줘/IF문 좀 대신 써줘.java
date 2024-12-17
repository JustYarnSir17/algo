import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        List<Node> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	list.add(new Node(st.nextToken(),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        
        for(int i=0;i<m;i++) {
        	int score = Integer.parseInt(br.readLine());
        	int left= 0;
        	int right= list.size()-1;
        	while(left<right) {
        		int mid= (left+right)/2;
        		if(score<=list.get(mid).score) {
        			right=mid;
        		}
        		else {
        			left=mid+1;
        		}
        	}
        	bw.write(list.get(left).name+"\n");
        }
        
    	bw.close();
    	br.close();
    }
}
class Node implements Comparable<Node>{
	String name;
	int score;
	Node(String name, int score){
		this.name=name;
		this.score=score;
	}
	@Override
	public int compareTo(Node o) {
		return this.score-o.score;
	}
	
}