import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n =Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
        	@Override
        	public int compare(Node o1,Node o2) {
        		return o1.end-o2.end;
        	}
        });
        Node[] arr = new Node[n];
        for(int i=0;i<n;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	arr[i]=new Node(start,end);
        	
        }
        Arrays.sort(arr,new Comparator<Node>(){
        	@Override
        	public int compare(Node o1,Node o2) {
        		return o1.start-o2.start;
        	}
        });
        
        for(int i=0;i<n;i++) {
        	if(pq.isEmpty()) {
        		pq.offer(arr[i]);
        	}
        	else {
        		if(pq.peek().end<=arr[i].start) {
        			pq.poll();
        			pq.offer(arr[i]);
        		}
        		else {
        			pq.offer(arr[i]);
        		}
        	}
        }
        
        
        bw.write(pq.size()+"");
        bw.close();
        br.close();
        
    }
}

class Node{
	int start;
	int end;
	Node(int start, int end){
		this.start=start;
		this.end=end;
	}
}