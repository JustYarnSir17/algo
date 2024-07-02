import  java.util.*;
import java.io.*;

public class Main {

	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<item> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n =Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int [] val = new int [m+1];
		
		for(int i=0;i<n;i++) {
			st= new StringTokenizer(br.readLine());
			int v= Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());
			int k =Integer.parseInt(st.nextToken());
			while(k>0) {
				if(k%2!=0) {
					stack.push(new item((v*(k/2+1)),(c*(k/2+1))));
					
			}
				else {
					stack.push(new item(v*(k/2),c*(k/2)));
				}
				k=k/2;
		}
		}
		
		while(!stack.isEmpty()) {
			item tmp = stack.pop();
			
			for(int i=m;i>=tmp.v;i--) {
				val[i] = Math.max(val[i],val[i-tmp.v]+tmp.c);
				
			}
		}
		bw.write(val[m]+"");
		bw.close();
		br.close();
	}

}
class item{
	int v;
	int c;
	item(int v,int c){
		this.v=v;
		this.c=c;
	}
}