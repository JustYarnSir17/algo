import java.io.*;
import java.util.*;

public class Main {
	static int [][] arr = new int [9][9];
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  

        for(int i=0;i<9;i++) {
        	String tmp = br.readLine();
        	for(int j=0;j<9;j++) {
        		arr[i][j]=tmp.charAt(j)-'0';
        	}
        }
        find();
        
        for(int i=0;i<9;i++) {
        	for(int j=0;j<9;j++) {
        		bw.write(String.valueOf(arr[i][j]));
        	}
        	bw.newLine();
        }
        bw.close();
        br.close();
    }
    
    public static boolean  find() {
    	for(int i=0;i<9;i++) {
    		for(int j=0;j<9;j++) {
    			if(arr[i][j]==0) {
    				for(int k=1;k<=9;k++) {
    					if(isValid(i,j,k)) {
    						arr[i][j]=k;
    						if(find()) {
    							return true;
    						}
    						arr[i][j]=0;
    					}
    				}
    				return false;
    				}
    		}
    	}
    	
    	return true;
    }
    
    
    public static boolean isValid(int r,int c,int num) {
    	
    	for(int i=0;i<9;i++) {
    		if(arr[i][c]==num) {
    			return false;
    		}
    		if(arr[r][i]==num) {
    			return false;
    		}
    	}
    	
    	int row = (r/3)*3;
    	int col = (c/3)*3;
    	
    	for(int i=row;i<row+3;i++) {
    		for(int j=col;j<col+3;j++) {
    			if(arr[i][j]==num)
    				return  false;
    		}
    	}
    	
    	return true;
    }
    
}