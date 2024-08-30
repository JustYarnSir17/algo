import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int x= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int [] arr= new int [n];
        for(int i=0;i<n;i++) {
        	int tmp =Integer.parseInt(st.nextToken());
        	arr[i]=tmp;
        }
        int visit=0;
        int cnt=0;
        int sum=0;
        for(int i=0;i<x;i++) {
        	sum+=arr[i];
        }
        int idx1=0;
        int idx2=x;
        while(idx2<n) {
        	if(visit<sum) {
        		visit=sum;
        		cnt=1;
        	}
        	else if(visit==sum) {
        		cnt++;
        	}
        	
        	sum-=arr[idx1++];
        	sum+=arr[idx2++];
        }
        if(visit<sum) {
        	visit=sum;
        	cnt=1;
        }
        else if(visit==sum) {
        	cnt++;
        }
        if(visit==0) {
        	bw.write("SAD");
        }
        else {
        bw.write(visit+"\n"+cnt);
        }
        bw.close();
        br.close();
        
        	
	}
}