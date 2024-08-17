import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str =br.readLine();
        int [] arr = new int [26];
        String mid=null;
        for(int i=0;i<str.length();i++) {
        	char tmp = str.charAt(i);
        	arr[tmp-'A']++;
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<=25;i++) {
        	if(arr[i]==1) {
        		if(mid!=null) {
        			bw.write("I'm Sorry Hansoo");
        			bw.close();
        			br.close();
        			return;
        		}
        		else {
        			mid=(char)('A'+i)+"";
        		}
        	}
        	else if(arr[i]>=2) {
        		if(arr[i]%2==0) {
        			int tmp =arr[i]/2;
        			for(int j=0;j<tmp;j++) {
        				sb.append((char)('A'+i)+"");
        			}
        		}
        		else {
        			if(mid!=null) {
        				bw.write("I'm Sorry Hansoo");
            			bw.close();
            			br.close();
            			return;
        			}
        			else {
        				int tmp =arr[i]/2;
            			for(int j=0;j<tmp;j++) {
            				sb.append((char)('A'+i)+"");
            			}
            			mid=(char)('A'+i)+"";
        			}
        		}
        		
        	}
        	
        }

        String reverse = sb.reverse().toString();
        sb.reverse();
        if(mid!=null) {
        	sb.append(mid);
        }
        sb.append(reverse);
        bw.write(sb.toString());
        bw.close();
        br.close();
        
    }
}