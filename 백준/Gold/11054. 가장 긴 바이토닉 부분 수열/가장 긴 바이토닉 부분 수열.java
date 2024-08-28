import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n =Integer.parseInt(br.readLine());
        int [] arr= new int [n];
        int []desc=new int[n];
        int []asc=new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	int tmp =Integer.parseInt(st.nextToken());
        	arr[i]=tmp;
        	asc[i]=1;
        	desc[i]=1;
        }
        for(int i=0;i<n;i++) {
        	for(int j=0;j<i;j++) {
        		if(arr[i]>arr[j]) {
        			asc[i]=Math.max(asc[i],asc[j]+1);
        		}
        	}
        }
        for(int i=n-1;i>=0;i--) {
        	for(int j=n-1;j>i;j--) {
        		if(arr[i]>arr[j]) {
        			desc[i]=Math.max(desc[i],desc[j]+1);
        		}
        	}
        }
        int answer=0;
        for(int i=0;i<n;i++) {
        	answer= Math.max(answer,asc[i]+desc[i]-1);
        }
        bw.write(answer+"");
        bw.close();
        br.close();
	}
}