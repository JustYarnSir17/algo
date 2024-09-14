import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer,Boolean> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        
        int a =Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<a;i++) {
        	int tmp =Integer.parseInt(st.nextToken());
        	map.put(tmp,true);
        	set.add(tmp);
        }
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<b;i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	if(map.containsKey(tmp)) {
        		map.replace(tmp,false);
        	}
        }
        
        int cnt=0;
        StringBuilder sb = new StringBuilder();
        for(int num:set) {
        	if(map.get(num)) {
        		cnt++;
        		sb.append(num+" ");
        		
        	}
        }
        if(cnt==0) {
        	bw.write("0");
        }
        else {
        bw.write(cnt+"\n"+sb.toString());
        }
        bw.close();
        br.close();
	}
	
}