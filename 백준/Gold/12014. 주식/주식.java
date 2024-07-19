import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int Time=1;Time<=T;Time++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int n =Integer.parseInt(st.nextToken());
        	int k =Integer.parseInt(st.nextToken());
        	int [] arr = new int[n];
        	st = new StringTokenizer(br.readLine());
        	for(int i=0;i<n;i++) {
        		int tmp = Integer.parseInt(st.nextToken());
        		arr[i]=tmp;	
        	}
        	int [] lis=new int[n];
        	int size=0;
        	for(int num:arr) {
        		int left=0,right=size;
        		while(left<right) {
        			int  mid=(left+right)/2;
        			if(num>lis[mid]) {
        				left=mid+1;
        			}
        			else {
        				right=mid;
        			}
        		}
        		lis[left]=num;
        		if(left==size) {
        			size++;
        			
        		}
        	}
        	bw.write("Case #"+Time+"\n");
        	if(size>=k) {
        		bw.write("1\n");
        	}
        	else {
        		bw.write("0\n");
        	}

        }
        
        bw.close();
        br.close();
    }
}