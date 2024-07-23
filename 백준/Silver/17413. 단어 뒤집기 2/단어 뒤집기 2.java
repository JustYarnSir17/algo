import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int idx1=0;
        int idx2=1;
        while(idx2<str.length()) {
        	if(str.charAt(idx1)=='<') {//태그를 이룰 때 
        		while(str.charAt(idx2)!='>')
        			idx2++;
        		if(str.charAt(idx2)=='>') {
        			for(int i=idx1;i<=idx2;i++) {
        				sb.append(str.charAt(i));
        			}
        			idx1=idx2+1;
        			idx2=idx1+1;
        		}
        		
        	}
        	else {//태그를 이루지 않을 때
        		if(str.charAt(idx2)==' ') {// 오른쪽 끝이 공백일때
        			for(int i=idx2-1;i>=idx1;i--) {
        				sb.append(str.charAt(i));
        			}
        			sb.append(' ');
        			idx1=idx2+1;
        			idx2=idx1+1;
        		}
        		else  if(str.charAt(idx2)=='<') {//태그 시작일 때
        			for(int i=idx2-1;i>=idx1;i--) {
        				sb.append(str.charAt(i));
        			}
        			idx1=idx2;
        			idx2=idx1+1;
        		}
        		else {//아무 것도 해당하지 않을때
        			if(idx2==str.length()-1) {//마지막 글자일때 
        				for(int i=idx2;i>=idx1;i--) {
            				sb.append(str.charAt(i));
            			}
        				break;
        			}
        			else {
        				idx2++;
        			}
        		}
        		
        	}
        	
        }
        
        bw.write(sb.toString());
        bw.close();
        br.close();
        
    }
}