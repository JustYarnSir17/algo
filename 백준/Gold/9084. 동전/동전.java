import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T= Integer.parseInt(br.readLine());
        for(int time=0;time<T;time++) {
        	int n =Integer.parseInt(br.readLine());
        	StringTokenizer st= new StringTokenizer(br.readLine());
        	int [] token=new int[n];
        	int [] amount = new int [10001];
        	for(int i=0;i<n;i++) {
        		int tmp = Integer.parseInt(st.nextToken());
        		token[i]=tmp;
        		
        	}
        	int m=Integer.parseInt(br.readLine());
        	for(int i=0;i<n;i++) {
        		amount[token[i]]++;
        		for(int j=1;j<=10000;j++) {
        			if(j-token[i]>=0) {
        				amount[j]+=amount[j-token[i]];
        			}
        		}
        	}
        	bw.write(amount[m]+"\n");
        }
        
        bw.close();
        br.close();
        
	}
}