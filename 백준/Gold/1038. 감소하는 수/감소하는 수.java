import java.io.*;
import java.util.*;

public class Main {
	static List<String> list =new ArrayList<>();
	static List<Character> str = new ArrayList<>();
	static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //9876543210 총 10자리까지만 
        
        for(int i=1;i<=10;i++) {
        	m=i;
        	find(10,0);
        }
        int n =Integer.parseInt(br.readLine());
        if(n>=list.size()) {
        	bw.write("-1");
        }
        else {
        	bw.write(list.get(n)+"");
        }
        bw.close();
        br.close();
        
        
    }
    
    public static void find(int idx,int cnt) {
    	if(cnt==m) {
    		StringBuilder sb = new StringBuilder();
    		for(int i=0;i<str.size();i++) {
    			sb.append(str.get(i));
    		}
    		list.add(sb.toString());
    	}
    	
    	for(int i=0;i<idx;i++) {
    		str.add(Character.forDigit(i, 10));
    		find(i,cnt+1);
    		str.remove(str.size()-1);
    	}
    	
    }
}