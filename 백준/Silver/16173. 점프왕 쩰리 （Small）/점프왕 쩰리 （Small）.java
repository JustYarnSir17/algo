import java.io.*;
import java.util.*;


public class Main {
	static int n;
	static int [][]arr;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        arr=new int [n][n];
        for(int i=0;i<n;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0;j<n;j++) {
        		int tmp = Integer.parseInt(st.nextToken());
        		arr[i][j]=tmp;
        	}
        }
        if(find()) {
        	bw.write("HaruHaru");
        }
        else {
        	bw.write("Hing");
        }
        bw.close();
        br.close();
        
	}
	
	public static boolean find() {
		Queue<Node> q= new LinkedList<>();
		q.offer(new Node(0,0));
		while(!q.isEmpty()) {
			Node curr= q.poll();
			if(curr.r==n-1&&curr.c==n-1) {
				return true;
			}
			if(arr[curr.r][curr.c]==0) {
				return false;
			}
			
			int jump=arr[curr.r][curr.c];
			if(curr.r+jump<n) {
				q.offer(new Node(curr.r+jump,curr.c));
				
			}
			if(curr.c+jump<n) {
				q.offer(new Node(curr.r,curr.c+jump));
			}
		}
		return false;
	}
}

class Node{
	int r;
	int c;
	Node(int r,int c){
		this.r=r;
		this.c=c;
	}
}