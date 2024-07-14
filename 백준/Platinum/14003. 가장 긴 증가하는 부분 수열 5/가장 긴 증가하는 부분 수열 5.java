import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n= Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	int  tmp = Integer.parseInt(st.nextToken());
        	arr[i]=tmp;
        }
        int [] answer= new int [n];
        int [] lis = new int[n];
        int [] pre =new int[n];
        Arrays.fill(answer,-1);
        int size=0;
        for(int i=0;i<n;i++) {
        	int x=arr[i];
        	int left=0,right=size;
        	while(left!=right) {
        		int mid= (left+right)/2;
        		if(lis[mid]<x) {
        			left=mid+1;
        		}
        		else {
        			right=mid;
        		}
        	}
        	lis[left]=x;
        	answer[left]=i;
        	if(left>0) {
        		pre[i]=answer[left-1];
        	}
        	else {
        		pre[i]=-1;
        	}
        	if(left==size) {
        		size++;
        	}
        }
        bw.write(String.valueOf(size)+"\n");
        int [] result= new int[size];
        int k =answer[size-1];
        for(int i=size-1;i>=0;i--) {
        	result[i]=arr[k];
        	k=pre[k];
        }
        for(int i=0;i<size;i++) {
        	bw.write(result[i]+" ");
        }
        bw.close();
        br.close();
        

    }
}