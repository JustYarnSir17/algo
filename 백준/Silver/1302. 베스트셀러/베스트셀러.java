import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        HashMap<String,Integer> map =new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<n;i++) {
        	String tmp = br.readLine();
        	if(!set.contains(tmp)) {
        		set.add(tmp);
        		map.put(tmp,1);
        	}
        	else {
        		
        		map.replace(tmp,map.get(tmp)+1);
        	}
        }
        int selling=0;
        String answer="";
        for(String book:set) {
        	if(selling<map.get(book)) {
        		selling=map.get(book);
        		answer= book;
        	}
        	else if(selling==map.get(book)) {
        		if(book.compareTo(answer)<0) {
        			answer=book;
        		}
        	}
        }
        bw.write(answer);
        bw.close();
        br.close();
	}
}