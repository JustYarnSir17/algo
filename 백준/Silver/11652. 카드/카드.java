import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Long,Integer> map = new HashMap<>();
        HashSet<Long> set = new HashSet<>();
        
        int n =Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
        	long tmp = Long.parseLong(br.readLine());
        	if(!map.containsKey(tmp)) {
        		map.put(tmp,1);
        		set.add(tmp);
        	}
        	else {
        		map.replace(tmp,map.get(tmp)+1);
        	}
        	
        }
        long num=0;
        int size=0;
        for(long val:set) {
        	int tmp = map.get(val);
        	if(tmp>size) {
        		num=val;
        		size=tmp;
        	}
        	else if(tmp==size) {
        		if(num>val) {
        			num=val;
        		}
        	}
        }
        
        bw.write(String.valueOf(num));
        bw.close();
        br.close();
        
	}
}