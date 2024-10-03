import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        int cnt=0;
        while(str.length()>10) {
        	bw.write(str.substring(0,10)+"\n");
        	str=str.substring(10);
        	
        }
        bw.write(str);
        bw.close();
        br.close();
	}
}