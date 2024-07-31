import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        for(int time=0;time<T;time++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int x1= Integer.parseInt(st.nextToken());
        	int y1= Integer.parseInt(st.nextToken());
        	
        	int r1 = Integer.parseInt(st.nextToken());
        	
        	int x2= Integer.parseInt(st.nextToken());
        	int y2= Integer.parseInt(st.nextToken());
        	
        	int r2 = Integer.parseInt(st.nextToken());
        	
        	if(x1==x2&&y1==y2) {
        		if(r1==r2) {
        			bw.write("-1\n");
        		}
        		else {
        			bw.write("0\n");
        		}
        	}
        	else {
        		double dist= Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
        		if(dist<r1+r2&&dist>Math.abs(r1-r2)) {
        			bw.write("2\n");
        		}
        		else if(dist==r1+r2||dist==Math.abs(r1-r2)) {
        			bw.write("1\n");
        		}
        		else {
        			bw.write("0\n");
        		}
        	}
        	
        }

    	bw.close();
    	br.close();
    }
}