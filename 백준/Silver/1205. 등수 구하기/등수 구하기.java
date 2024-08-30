import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int score= Integer.parseInt(st.nextToken());
        int p=Integer.parseInt(st.nextToken());
        if(n>0) {
        	st=new StringTokenizer(br.readLine());
        	int rank=1;
        	int cnt=0;
            for(int i=1;i<=n;i++) {
            	int tmp =Integer.parseInt(st.nextToken());
            	if(score<tmp) {
            		rank++;
            	}
            	else if(score==tmp) {
            		cnt++;
            	}
            	else {
            		break;
            	}
            	
            }
            if(rank+cnt<=p) {
            	bw.write(String.valueOf(rank));
            }
            else {
            	bw.write("-1");
            }
            
        }
        else {
        	bw.write("1");
        }
        
        br.close();
        bw.close();
        
        	
	}
}