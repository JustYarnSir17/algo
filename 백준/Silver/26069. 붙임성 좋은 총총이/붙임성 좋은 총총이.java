import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        HashMap<String,Boolean> map = new HashMap<>();
        HashSet<String> set= new HashSet<>();
        
        map.put("ChongChong",true);
        
        for(int i=0;i<n;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	String tmp1 = st.nextToken();
        	String tmp2 = st.nextToken();
        	if(!set.contains(tmp1)) {
        		set.add(tmp1);
        	}
        	if(!set.contains(tmp2)) {
        		set.add(tmp2);
        	}
        	if(!map.containsKey(tmp1)) {
        		if(!map.containsKey(tmp2)) {
        			map.put(tmp1,false);
        			map.put(tmp2,false);
        		}
        		else {
        			if(map.get(tmp2)) {
        				map.put(tmp1,true);
        			}
        			else {
        				map.put(tmp1,false);
        			}
        		}
        	}
        	else {
        		if(!map.containsKey(tmp2)) {
        			if(map.get(tmp1)) {
        				map.put(tmp2,true);
        			}
        			else {
        				map.put(tmp2,false);
        			}
        			
        		}
        		else {
        			if(map.get(tmp1)||map.get(tmp2)) {
        				map.replace(tmp1,true);
        				map.replace(tmp2,true);
        			}
        		}
        		
        	}
        	
        }
        
        int cnt=0;
        for(String str:set) {
        	if(map.get(str)) {
        		cnt++;
        	}
        }
        bw.write(cnt+"");
        br.close();
        bw.close();
        
	}
	
}