import java.io.*;
import java.util.*;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n =Integer.parseInt(br.readLine());
        int [] arr =new int [n];
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++) {
        	int tmp =Integer.parseInt(br.readLine());
        	arr[i]=tmp;
        	if(!set.contains(tmp)) {
        		set.add(tmp);
        	}
        }
        int cnt=0;
        for(int num:set) {
        	int prev=arr[0];
        	int count=1;
        	for(int i=1;i<n;i++) {
        		if(arr[i]==num) {
        			continue;
        		}
        		if(arr[i]==prev) {
        			count++;
        		}
        		else {
        			prev=arr[i];
        			count=1;
        		}
        		cnt=Math.max(cnt,count);
        	}
        }
        bw.write(cnt+"");
        bw.close();
        br.close();
        
        
	}
}