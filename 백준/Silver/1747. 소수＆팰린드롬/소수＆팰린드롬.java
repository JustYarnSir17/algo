import  java.util.*;
import java.io.*;

public class Main {

	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		boolean [] arr= new boolean [2000000];
		arr[1]=true;
		for(int i=2;i<2000000;i++) {
			for(int j=2;j*i<2000000;j++) {
				arr[i*j]=true;
			}
		}
		
		int n = Integer.parseInt(br.readLine());
		for(int i=n;i<2000000;i++) {
			if(!arr[i]) {
				String tmp = String.valueOf(i);
				StringBuffer sb = new StringBuffer(tmp);
				String reverse = sb.reverse().toString();
				if(tmp.equals(reverse)) {
					bw.write(tmp+"");
					break;
				}
				
			}
		}
		bw.close();
		br.close();
	}

}