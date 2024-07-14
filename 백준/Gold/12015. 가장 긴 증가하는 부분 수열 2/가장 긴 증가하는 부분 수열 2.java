import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int a=Integer.parseInt(br.readLine());
        int [] dp = new int [a];
        int [] arr = new int [a];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<a;i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	arr[i]=tmp;
        }
        int size=0;
        for(int x:arr) {
        	int i=0, j=size;
        	while(i!=j) {
        		int mid=(i+j)/2;
        		if(dp[mid]<x) {
        			i=mid+1;
        		}
        		else {
        			j=mid;
        		}
        	}
        	dp[i]=x;
        	if(i==size) {
        		size++;
        	}
        }
        bw.write(size+"");
        bw.close();
        br.close();

    }
}