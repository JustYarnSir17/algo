import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        HashSet<String> set = new LinkedHashSet<>();
        for(int i=0;i<l;i++) {
        	String str = br.readLine();
        	if(set.contains(str)) {
        		set.remove(str);
        		set.add(str);
        	}
        	else {
        		set.add(str);
        	}
        }
        int cnt=0;
        for(String student:set) {
        	cnt++;
        	bw.write(student+"\n");
        	if(cnt==k)
        		break;
        }
        bw.close();
        br.close();
        
	}
}