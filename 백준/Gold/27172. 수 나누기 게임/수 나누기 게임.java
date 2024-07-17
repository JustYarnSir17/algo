import java.io.*;
import java.util.*;

public class Main {
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  

        int n =Integer.parseInt(br.readLine());
        int mNum=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr =  new int [n];
        

        for(int i=0;i<n;i++) {
        	int tmp =Integer.parseInt(st.nextToken());
        	arr[i]=tmp;
        	mNum=Math.max(tmp,mNum);
        }
        boolean [] id = new boolean[mNum+1];
        int [] score =new int [mNum+1];
        for(int num:arr) {
        	id[num]=true;
        }
        for(int i=1;i<=mNum;i++) {
        	if(id[i]) {
        		for(int j=2*i;j<=mNum;j+=i) {
        			if(id[j]) {
        				score[i]++;
            			score[j]--;
        			}
        		}
        	}
        }
        
        for(int i=0;i<n;i++) {
        	bw.write(score[arr[i]]+" ");
        }
        bw.close();
        br.close();
        
        
    }
    
    
}