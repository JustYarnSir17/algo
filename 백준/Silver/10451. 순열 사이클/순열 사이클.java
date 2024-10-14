import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t= Integer.parseInt(br.readLine());
        for(int time=0;time<t;time++) {
        	int n =Integer.parseInt(br.readLine());
        	int [] arr = new int [n+1];
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	for(int i=1;i<=n;i++) {
        		int tmp = Integer.parseInt(st.nextToken());
        		arr[i]=tmp;
        	}
        	boolean[] v =new boolean[n+1];
        	int cnt=0;
        	for(int i=1;i<=n;i++) {
        		int idx =i;
        		if(!v[idx]) {
        		while(!v[idx]) {
        			v[idx]=true;
        			idx=arr[idx];
        			
        		}
        		if(idx==i) {
        			cnt++;
        		}
        		}
        		
        	}
        	bw.write(cnt+"\n");
        }
        bw.close();
        br.close();
        
	}	
	
	
}