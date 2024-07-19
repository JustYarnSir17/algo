import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        int [][] arr = new int [n][n];
        int [][] path = new int [n][n];
        for(int i=0;i<n;i++) {
        	Arrays.fill(arr[i],10000000);
        	arr[i][i]=0;
        	
        }
       
        for(int i=0;i<m;i++) {
        	st=new StringTokenizer(br.readLine());
        	int a =Integer.parseInt(st.nextToken())-1;
        	int b = Integer.parseInt(st.nextToken())-1;
        	int cost = Integer.parseInt(st.nextToken());
        	arr[a][b]=cost;
        	arr[b][a]=cost;
        	path[a][b]=b;
        	path[b][a]=a;
        }
        
        for(int k=0;k<n;k++) {
        	for(int i=0;i<n;i++) {
        		for(int j=0;j<n;j++) {
        			if(arr[i][j]>arr[i][k]+arr[k][j]) {
        				arr[i][j]=arr[i][k]+arr[k][j];
        				path[i][j]=path[i][k];
        			}
        		}
        	}
        }
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(i==j) {
        			bw.write("- ");
        		}
        		else {
        			bw.write(path[i][j]+1+" ");
        		}
        		
        		
        	}
        	bw.newLine();
        }
        bw.close();
        br.close();
        
    }
}