import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r= Integer.parseInt(st.nextToken());
        int c= Integer.parseInt(st.nextToken());
        String[] arr =new String[c];
        Arrays.fill(arr,"");
        
        for(int i=0;i<r;i++) {
        	String tmp = br.readLine();
        	for(int j=0;j<c;j++) {
        		arr[j]+=tmp.charAt(j);
        	}
        }
        int cnt=0;
        loop:
        for(int i=0;i<r-1;i++) {
        	HashSet<String> set = new HashSet<>();
        	for(int j=0;j<c;j++) {
        		arr[j]=arr[j].substring(1);
        		if(set.contains(arr[j])) {
        			break loop;
        		}
        		else {
        			set.add(arr[j]);
        		}
        	}
        	cnt++;
        }
        
        bw.write(cnt+"");
        bw.close();
        br.close();
    }
}