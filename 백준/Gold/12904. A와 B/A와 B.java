import java.io.*;
import java.util.*;

import javax.net.ssl.HttpsURLConnection;

public class Main {
	static Queue<String> q =new LinkedList<>();
	static String T;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        T= br.readLine();
        while(T.length()>str.length()) {
        	int end = T.length()-1;
        	if(T.charAt(end)=='A') {
        		T=T.substring(0,end);
        	}
        	else {
        		StringBuilder sb =new StringBuilder(T.substring(0,end));
        		T=sb.reverse().toString();
        	}
        }
        if(T.equals(str)) {
        	bw.write("1");
        }
        else {
        	bw.write("0");
        }
        bw.close();
        br.close();
	}
}