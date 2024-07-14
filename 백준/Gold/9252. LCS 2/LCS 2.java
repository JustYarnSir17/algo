import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1= br.readLine();
        String str2= br.readLine();
        int [][] lcs= new int [str1.length()+1][str2.length()+1];
        
        for(int i=1;i<=str1.length();i++) {
        	for(int j=1;j<=str2.length();j++) {
        		if(str1.charAt(i-1)==str2.charAt(j-1)) {
        			lcs[i][j]=lcs[i-1][j-1]+1;
        		}
        		else {
        			lcs[i][j]=Math.max(lcs[i-1][j],lcs[i][j-1]);
        		}
        	}
        }
        int m=str1.length();
        int n=str2.length();
        
        StringBuilder sb= new StringBuilder();
        
        while(m>0&&n>0) {
        	if(str1.charAt(m-1)==str2.charAt(n-1)) {
        		sb.append(str1.charAt(m-1));
        		m--;
        		n--;
        	}
        	else if(lcs[m-1][n]>lcs[m][n-1]) {
        		m--;
        	}
        	else {
        		n--;
        	}
        }
        bw.write(lcs[str1.length()][str2.length()]+"\n");
        bw.write(sb.reverse().toString());
        bw.close();
        br.close();
    }
}