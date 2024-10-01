import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n =Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int [n];
        boolean [] v= new boolean[n];
        for(int i=0;i<n;i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	arr[i]= tmp;	
        }
        if(n>1) {
        	Queue<Node> q= new LinkedList<>();
            q.offer(new Node(0,arr[0]));
            v[0]=true;
            int cnt=0;
            boolean tr=false;
            loop:
            while(!q.isEmpty()) {
            	int size= q.size();
            	cnt++;
            	for(int s=0;s<size;s++) {
            		Node curr = q.poll();
            		if(curr.val>0) {
            			for(int i=1;i<=curr.val;i++) {
            				if(curr.idx+i==n-1) {
            					tr=true;
            					break loop;
            					
            				}
            				if(curr.idx+1<n&&!v[curr.idx+i]) {
            					v[curr.idx+i]=true;
            					q.offer(new Node(curr.idx+i,arr[curr.idx+i]));
            				}
            			}
            		}
            	}
            }
            if(tr) {
            bw.write(cnt+"");
            }
            else {
            	bw.write("-1");
            }
        }
        else {
        	bw.write("0");
        }
        bw.close();
        br.close();
        
        
	}
}

class Node{
	int idx;
	int val;
	Node(int idx, int val){
		this.idx=idx;
		this.val=val;
	}
}