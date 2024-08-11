import java.io.*;
import java.util.*;

public class Main {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        String str = br.readLine();
	        int zero=0;
	        int one =0;
	        boolean zTr=false;
	        boolean oTr=false;
	        for(int i=0;i<str.length();i++) {
	        	if(str.charAt(i)=='0') {//0일 때
	        		if(zTr) {//만약 그전에 0이 연속되게 등장했을 경우
	        			continue;
	        		}
	        		else {//처음 등장했을 경우
	        			zTr=true;
	        			
	        		}
	        		if(oTr) {//그전에 1이 등장했을 경우
	        			oTr=false;
	        			one++;
	        		}
	        		
	        	}
	        	else {//1일 때
	        		if(zTr) {//그 전에 0이 등장했을 때
	        			zTr=false;
	        			zero++;
	        		}
	        		if(oTr) {//그 전에 1이 등장했을 때
	        			continue;
	        		}
	        		else {//1이 처음 등장했을 때
	        			oTr=true;
	        		}
	        		
	        	}
	        }
	        if(oTr) {
	        	one++;
	        }
	        if(zTr) {
	        	zero++;
	        }
	        

	        if(zero>one) {
	        	bw.write(one+"");
	        }else {
	        	bw.write(zero+"");
	        }
	        bw.close();
	        br.close();
	 }
}