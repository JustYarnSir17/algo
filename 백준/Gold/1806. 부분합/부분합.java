import java.io.*;
import java.util.*;

public class Main {
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  

        StringTokenizer st = new  StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int [] arr = new int [n];
        
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	arr[i]=tmp;
        }
        int idx1=0;
        int idx2=0;
        int sum=arr[idx1];
        int m =  100000;
        while(idx1<=idx2) {
        	
        	if(sum>=s) {
        		if(m>idx2-idx1+1) {
        			m=idx2-idx1+1;
        		}
        		sum-=arr[idx1++];
        		
        	}
        	else {
        		if(idx2==n-1) {
        			break;
        		}
        		else
        			sum+=arr[++idx2];
        	}
        }
        if(m==100000) {
        	bw.write("0");
        }
        else {
        bw.write(m+"");
        }
        bw.close();
        br.close();
    }
    
    
}