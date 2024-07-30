import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n =Integer.parseInt(br.readLine());
        HashSet<String> set=new HashSet<>();
        int cnt=0;
        for(int i=0;i<n;i++) {
        	String str = br.readLine();
        	if(str.equals("ENTER")) {
        		set=new HashSet<>();
        	}
        	else {
        		if(set.contains(str)) {
        			continue;
        		}
        		else {
        			cnt++;
        			set.add(str);
        		}
        	}
        }
        bw.write(cnt+"");
        bw.close();
        br.close();
    }
}