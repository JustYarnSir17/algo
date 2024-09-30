import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        boolean [] arr = new boolean[1000001];
        arr[1]=true;
        for(int i=2;i<=1000000;i++) {
        	for(int j=2;j*i<=1000000;j++) {
        		arr[i*j]=true;
        	}
        }
        
        int n =Integer.parseInt(br.readLine());
        
        for(int t=0;t<n;t++) {
        	int tmp =Integer.parseInt(br.readLine());
        	int cnt=0;
        	int idx1=1;
        	int idx2=tmp-1;
        	while(idx1<=idx2) {
        		if(!arr[idx1]&&!arr[idx2]) {
        			cnt++;
        		}
        		idx1++;
        		idx2--;
        	}
        	bw.write(cnt+"\n");
        }
       bw.close();
       br.close();
	}
}