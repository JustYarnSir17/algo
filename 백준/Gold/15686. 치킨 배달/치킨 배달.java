import java.io.*;
import java.util.*;


public class Main {
	static int n,m;
	static List<Node> chicken =new ArrayList<>();
	static List<Node> house = new ArrayList<>();
	static int dist=Integer.MAX_VALUE;
	static Stack<Node> survive = new Stack<>();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st =new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        
        
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<n;j++) {
        		int tmp =Integer.parseInt(st.nextToken());
        		
        		if(tmp==2) {
        			chicken.add(new Node(i,j));
        		}
        		else if(tmp==1) {
        			house.add(new Node(i,j));
        		}
        	}
        }
        find();
        bw.write(dist+"");
        bw.close();
        br.close();
        
           
	}
	
	
	public static void find() {
		find(0,-1);
	}
	
	public static void find(int cnt,int idx) {
		if(cnt==m) {
			int sum=0;
			for(int i=0;i<house.size();i++) {
				int this_house=Integer.MAX_VALUE;
				Node h=house.get(i);
				for(int j=0;j<survive.size();j++) {
					Node c= survive.get(j);
					int distance= Math.abs(h.r-c.r)+Math.abs(h.c-c.c);
					this_house=Math.min(this_house,distance);
				}
				sum+=this_house;
			}
			dist=Math.min(dist,sum);
			
			return;
		}
		
		for(int i=idx+1;i<chicken.size();i++) {
			survive.push(chicken.get(i));
			find(cnt+1,i);
			survive.pop();
		}
	}
	
}

class Node{
	int r;
	int c;
	Node(int r, int c){
		this.r=r;
		this.c=c;
	}
}