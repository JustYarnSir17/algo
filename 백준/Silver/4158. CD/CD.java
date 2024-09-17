import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n =Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        while(n!=0&&m!=0) {
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<n;i++) {
        	int tmp =Integer.parseInt(br.readLine());
        	if(!set.contains(tmp)) {
        		set.add(tmp);
        	}
        }
        int cnt=0;
        for(int i=0;i<m;i++) {
        	int tmp =Integer.parseInt(br.readLine());
        	if(set.contains(tmp)) {
        		cnt++;
        	}
        }
        bw.write(cnt+"\n");
        st=new StringTokenizer(br.readLine());
        n =Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken());
        }
        bw.close();
        br.close();
	}
}