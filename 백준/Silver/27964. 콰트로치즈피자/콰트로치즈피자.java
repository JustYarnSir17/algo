import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<String> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<n;i++) {
        	String str =st.nextToken();
        	
        	if(str.length()>=6&&"Cheese".compareTo(str.substring(str.length()-6))==0) {
        		set.add(str);
        	}
        }
        if(set.size()>=4) {
        	bw.write("yummy");
        }
        else {
        	bw.write("sad");
        }
        bw.close();
        br.close();

        
        
        
	}
	
}