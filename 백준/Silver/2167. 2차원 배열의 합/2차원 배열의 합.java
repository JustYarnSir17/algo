import java.io.*;
import java.util.*;


public class Main {
	
	static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n =Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][] arr= new int [n][m];
        
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<m;j++) {
        		int tmp = Integer.parseInt(st.nextToken());
        		arr[i][j]=tmp;
        	}
        }
        
        int k=Integer.parseInt(br.readLine());
        for(int t=0;t<k;t++) {
        	st=new StringTokenizer(br.readLine());
        	int i = Integer.parseInt(st.nextToken());
        	int j = Integer.parseInt(st.nextToken());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	int sum=0;
        	for(int r=i-1;r<x;r++) {
        		for(int c=j-1;c<y;c++) {
        			sum+=arr[r][c];
        		}
        	}
        	bw.write(sum+"\n");
        }
        
        bw.close();
        br.close();
        
        
	}
}