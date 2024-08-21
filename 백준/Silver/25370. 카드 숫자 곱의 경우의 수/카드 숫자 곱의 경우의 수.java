import java.io.*;
import java.util.*;



public class Main {
	static HashSet<Integer> set =new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        find(n,0,1);
        bw.write(set.size()+"");
        bw.close();
        br.close();
        
	}
    
    public static void find(int n,int cnt, int num) {
    	if(cnt==n) {
    		set.add(num);
    		return;
    	}
    	
    	for(int i=1;i<=9;i++) {
    		find(n,cnt+1,num*i);
    	}
    }
    

}