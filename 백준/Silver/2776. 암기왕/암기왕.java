import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int time=0;time<T;time++) {
        	int n=Integer.parseInt(br.readLine());
        	HashSet<Integer> set = new HashSet<>();
        	StringTokenizer st= new StringTokenizer(br.readLine());
        	for(int i=0;i<n;i++) {
        		int tmp =Integer.parseInt(st.nextToken());
        		set.add(tmp);
        	}
        	int m=Integer.parseInt(br.readLine());
        	st=new StringTokenizer(br.readLine());
        	
        	for(int i=0;i<m;i++) {
        		int tmp =Integer.parseInt(st.nextToken());
        		if(set.contains(tmp)) {
        			bw.write("1\n");
        		}
        		else {
        			bw.write("0\n");
        			
        		}
        	}
        	bw.flush();
        }
        bw.close();
        br.close();
        
	}
	
}