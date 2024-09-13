import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        HashMap<String,Integer> map = new HashMap<>();
        HashSet<String> set=  new HashSet<>();
        for(int i=0;i<n;i++) {
        	String str = br.readLine();
        	if(set.contains(str)) {
        		map.replace(str,map.get(str)+1);
        	}
        	else {
        		set.add(str);
        		map.put(str,1);
        	}
        }
        
        for(int i=0;i<n-1;i++) {
        	String str= br.readLine();
        	map.replace(str,map.get(str)-1);
        }
        
        for(String name:set) {
        	if(map.get(name)!=0) {
        		bw.write(name);
        		break;
        	}
        }
        bw.close();
        br.close();
	}
	
}