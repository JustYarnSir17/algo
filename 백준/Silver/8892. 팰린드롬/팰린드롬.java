import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t= Integer.parseInt(br.readLine());
        for(int time=0;time<t;time++) {
        	int k =Integer.parseInt(br.readLine());
        	String[] arr= new String[k];
        	for(int i=0;i<k;i++) {
        		String str =br.readLine();
        		arr[i]=str;
        	}
        	boolean tr=true;;
        	loop:
        	for(int i=0;i<k;i++) {

        		for(int j=0;j<k;j++) {
        			if(i==j) {
        				continue;
        			}
        			tr=false;
        			StringBuilder sb = new StringBuilder(arr[i]);
        			sb.append(arr[j]);
        			String str=sb.toString();
        			for(int l=0;l<str.length()/2;l++) {
        				if(str.charAt(l)!=str.charAt(str.length()-1-l)) {
        					tr=true;
        					break;
        				}
        			}
        			if(!tr) {
        				bw.write(str+"\n");
        				break loop;
        			}
        				
        		}
        	}
        	
        	if(tr) {
        		bw.write("0\n");
        	}
        }
        bw.close();
        br.close();
	}
}