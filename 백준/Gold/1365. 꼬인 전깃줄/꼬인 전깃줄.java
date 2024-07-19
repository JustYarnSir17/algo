import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n =Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	arr[i]=tmp;
        }
        int [] lis=new int[n];
        int size=0;
        for(int num:arr) {
        	int left=0,right=size;
        	while(left<right) {
        		int mid=(left+right)/2;
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
        bw.write((n-size)+"");
        bw.close();
        br.close();
    }
    
}