import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        
        for(int i=0;i<n;i++) {
        	String tmp = br.readLine();
        	for(int j=0;j<n;j++) {
        		arr[i][j]=tmp.charAt(j);
        	}
        }
        
        int r=0;
        int c=0;
        
        for(int i=0;i<n;i++) {
        	int cnt=0;
        	for(int j=0;j<n;j++) {
        		if(arr[i][j]=='.') {
        			cnt++;
        		}
        		else {
        			if(cnt>=2) {
        				c++;
        			}
        			cnt=0;
        		
        		}
        	}
        	if(cnt>=2) {
        		c++;
        	}
        }
        
        for(int j=0;j<n;j++) {
        	int cnt=0;
        	for(int i=0;i<n;i++) {
        		if(arr[i][j]=='.') {
        			cnt++;
        		}
        		else {
        			if(cnt>=2) {
        				r++;
        			}
        			cnt=0;
        		}
        	}
        	if(cnt>=2) {
        		r++;
        	}
        }
        bw.write(c+" "+r);
        bw.close();
        br.close();
	}
	
}