import java.io.*;
import java.util.*;

public class Main {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        String str = br.readLine();
	        HashSet<String> set = new HashSet<>();
	        for(int i=0;i<str.length();i++) {
	        	for(int j=i+1;j<str.length()+1;j++) {
	        		set.add(str.substring(i,j));
	        	}
	        }
	        bw.write(set.size()+"");
	        bw.close();
	        br.close();
	        
	 }
}