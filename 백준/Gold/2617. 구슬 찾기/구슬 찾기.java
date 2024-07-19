import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer  st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int [][]arr=new int [n][n];
        for(int i=0;i<m;i++) {
        	st=new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken())-1;
        	int b=Integer.parseInt(st.nextToken())-1;
        	arr[a][b]=1;
        	arr[b][a]=-1;
        	
        }
        for(int k=0;k<n;k++) {
        	for(int i=0;i<n;i++) {
        		for(int j=0;j<n;j++) {
        			if(arr[i][k]==1&&arr[k][j]==1) {
        				arr[i][j]=1;
        			}
        			else if(arr[i][k]==-1&&arr[k][j]==-1) {
        				arr[i][j]=-1;
        			}
        		}
        	}
        }
        int cnt=0;
        int mid=(n+1)/2;
        for(int i=0;i<n;i++) {
        	int heavier=0;
        	int lighter=0;
        	for(int j=0;j<n;j++) {
        		if(arr[i][j]==1) {
        			heavier++;
        		}
        		else if(arr[i][j]==-1) {
        			lighter++;
        		}
        	}
        	if(heavier>=mid||lighter>=mid) {
        		++cnt;
        	}
        }
        bw.write(cnt+"");
        bw.close();
        br.close();
    }
    
}