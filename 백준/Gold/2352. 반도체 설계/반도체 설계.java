import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n =Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	int tmp= Integer.parseInt(st.nextToken());
        	arr[i]=tmp;
        }
        
        int size=0;
        int []lis= new int[n];
        for(int x: arr) {
        	int i=0,j=size;
        	while(i!=j) {
        		int mid=(i+j)/2;
        		if(lis[mid]<x) {
        			i=mid+1;
        		}
        		else {
        			j=mid;
        		}
        	}
        	lis[i]=x;
        	if(i==size) {
        		size++;
        	}
        }
        bw.write(String.valueOf(size));
        bw.close();
        br.close();

    }
}