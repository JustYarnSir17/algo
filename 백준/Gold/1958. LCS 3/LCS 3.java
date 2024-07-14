import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1= br.readLine();
        String str2= br.readLine();
        String str3= br.readLine();
        int cnt=find(str1,str2,str3);
        bw.write(String.valueOf(cnt));
        bw.close();
        br.close();
        		
    }
    
    public static int find(String str1,String str2,String str3) {
    	int n=str1.length();
    	int m=str2.length();
    	int l=str3.length();
    	int [][][] arr =new int [n+1][m+1][l+1];
    	
    	for(int i=0;i<=n;i++) {
    		for(int j=0;j<=m;j++) {
    			for(int k=0;k<=l;k++) {
    				if(i==0||j==0||k==0) {
    					arr[i][j][k]=0;
    				}else  if(str1.charAt(i-1)==str2.charAt(j-1)&&str2.charAt(j-1)==str3.charAt(k-1)) {
    					arr[i][j][k]= arr[i-1][j-1][k-1]+1;
    					
    				}
    				else {
    					arr[i][j][k]=Math.max(Math.max(arr[i-1][j][k],arr[i][j-1][k]),arr[i][j][k-1]);
    				}
    			}
    		}
    	}
    	return arr[n][m][l];
    }
}