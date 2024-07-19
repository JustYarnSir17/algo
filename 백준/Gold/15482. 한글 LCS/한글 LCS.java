import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1=br.readLine();
        String str2=br.readLine();
        if(str1.length()>str2.length()) {
        	String tmp = str1;
        	str1=str2;
        	str2=tmp;
        }
        
        int size1=str1.length();
        int size2=str2.length();
        int [] pre= new int [size1+1];
        int [] cur=new int [size1+1];
        for(int j=1;j<=size2;j++) {
        	for(int i=1;i<=size1;i++) {
        		if(str1.charAt(i-1)==str2.charAt(j-1)) {
        			cur[i]=pre[i-1]+1;
        			
        		}
        		else {
        			cur[i]=Math.max(cur[i-1],pre[i]);
        		}
        	}
        	int[] tmp=pre;
        	pre=cur;
        	cur=tmp;
        }
        bw.write(pre[size1]+"");
        bw.close();
        br.close();
        
    }
}