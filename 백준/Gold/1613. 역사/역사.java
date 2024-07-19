import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer  st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int [][]arr=new int [n][n];
        
        for(int i=0;i<k;i++) {
        	st=new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken())-1;
        	int b=Integer.parseInt(st.nextToken())-1;
        	arr[a][b]=-1;
        	arr[b][a]=1;
        	
        }
        for(int l=0;l<n;l++) {
        	for(int i=0;i<n;i++) {
        		for(int j=0;j<n;j++) {
        			if(arr[i][l]==1&arr[l][j]==1) {
        				arr[i][j]=1;
        			}
        			else if(arr[i][l]==-1&&arr[l][j]==-1) {
        				arr[i][j]=-1;
        			}
        		}
        	}
        }
        int s=Integer.parseInt(br.readLine());
        for(int i=0;i<s;i++) {
        	st=new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken())-1;
        	int b=Integer.parseInt(st.nextToken())-1;
        	bw.write(arr[a][b]+"\n");
        }
        bw.close();
        br.close();
        
    }
}