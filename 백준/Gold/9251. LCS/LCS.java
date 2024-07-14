import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1= br.readLine();
        String str2= br.readLine();
        
        int n=str1.length();
        int m=str2.length();
        
        int[][] arr = new int [n+1][m+1];
        for(int i=1;i<=n;i++) {
        	for(int j=1;j<=m;j++) {
        		if(str1.charAt(i-1)==str2.charAt(j-1)) {
        			arr[i][j]=arr[i-1][j-1]+1;
        			
        		}
        		else {
        			arr[i][j]=Math.max(arr[i-1][j],arr[i][j-1]);
        		}
        	}
        }
        bw.write(String.valueOf(arr[n][m]));
        bw.close();
        br.close();
        		
    }
}