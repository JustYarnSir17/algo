import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1=br.readLine();
        String str2=br.readLine();
        int len1=str1.length();
        int len2=str2.length();
        
        int [][] arr =new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++) {
        	for(int j=1;j<=len2;j++) {
        		if(str1.charAt(i-1)==str2.charAt(j-1)) {
        			arr[i][j]=arr[i-1][j-1]+1;
        			
        		}

        		
        	}
        }
        int answer=0;
        for(int i=0;i<=len1;i++) {
        	for(int j=0;j<=len2;j++) {
        		answer=Math.max(answer,arr[i][j]);
        	}
        	
        }
        bw.write(answer+"");
        bw.close();
        br.close();
        
    }
}