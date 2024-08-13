import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n =Integer.parseInt(br.readLine());
        int []answer= new int [n+1];
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
        	@Override
        	public int compare(Node o1,Node o2) {
        		return o1.end-o2.end;
        	}
        });
        Node[] arr = new Node[n];
        for(int i=0;i<n;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int num = Integer.parseInt(st.nextToken());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	arr[i]=new Node(num,start,end);
        	
        }
        Arrays.sort(arr,new Comparator<Node>(){
        	@Override
        	public int compare(Node o1,Node o2) {
        		return o1.start-o2.start;
        	}
        });
        int idx=1;
        for(int i=0;i<n;i++) {
        	if(pq.isEmpty()) {
        		answer[arr[i].num]=idx++;
        		pq.offer(arr[i]);
        		
        	}
        	else {
        		if(pq.peek().end<=arr[i].start) {
        			Node node=pq.poll();
        			answer[arr[i].num]=answer[node.num];
        			pq.offer(arr[i]);
        		}
        		else {
        			answer[arr[i].num]=idx++;
        			pq.offer(arr[i]);
        		}
        	}
        }
        
        
        bw.write(pq.size()+"\n");
        for(int i=1;i<=n;i++) {
        	bw.write(answer[i]+"\n");
        }
        bw.close();
        br.close();
        
    }
}

class Node{
	int num;
	int start;
	int end;
	int idx=0;
	Node(int num,int start, int end){
		this.num=num;
		this.start=start;
		this.end=end;
	}
}