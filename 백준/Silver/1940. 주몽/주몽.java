import java.io.*;
import java.util.*;


public class Main {
	
	static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt=0;
        int n =Integer.parseInt(br.readLine());
        int m =Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int [] arr = new int[n];
        for(int i=0;i<n;i++) {
        	int tmp =Integer.parseInt(st.nextToken());
        	arr[i]=tmp;
        }
        
        for(int i=0;i<n;i++) {
        	for(int j=i+1;j<n;j++) {
        		if(arr[i]+arr[j]==m) {
        			cnt++;
        		}
        	}
        }
        bw.write(cnt+"");
        bw.close();
        br.close();
        
        
	}
}