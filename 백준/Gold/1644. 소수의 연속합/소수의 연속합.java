import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        boolean [] arr= new boolean[4000001];
        arr[0]=true;
        arr[1]=true;
        List<Integer>list = new ArrayList<>();
        for(int i=2;i<=4000000;i++) {
        	for(int j=2;i*j<=4000000;j++) {
        		arr[i*j]=true;
        	}
        }
        for(int i=2;i<=4000000;i++) {
        	if(!arr[i])
        		list.add(i);
        }
        int n =Integer.parseInt(br.readLine());
        
        int idx1=0;
        int idx2=0;
        int sum=list.get(idx1);
        int count=0;
        while(idx2<list.size()&&idx1<=idx2) {
        	if(sum==n) {
        		++count;
        		
        		if(idx1+1<=idx2) {
        			sum-=list.get(idx1++);
        			
        		}
        		else {
        			if(idx2+1<list.size()) {
        			sum-=list.get(idx1++);
        			sum+=list.get(++idx2);
        			}
        			else {
        				break;
        			}
        		}
        	}
        	else if(sum>n) {
        		sum-=list.get(idx1++);
        		
        	}
        	else {
        		if(idx2+1<list.size()) {
        			sum+=list.get(++idx2);
        		}
        		else {
        			break;
        		}
        	}
        	
        	
        	
        }
        bw.write(count+"");
        bw.close();
        br.close();
       
    }
    
}