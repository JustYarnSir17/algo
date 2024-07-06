import  java.util.*;
import java.io.*;

public class Main {

	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n =Integer.parseInt(br.readLine());
		int [] arr = new int [n];
		String str = br.readLine();
		int e=0;
		int o=0;
		
		int answer=0;
		for(int i=0;i<n;i++) {
			arr[i]= str.charAt(i)-'0';
			if(arr[i]%2==0) {
				++e;
			}
			else {
				++o;
			}
		}
		if(e>o) {
			answer=0;
		}
		else  if(o>e) {
			answer=1;
		}
		else {
			answer=-1;
		}
		bw.write(answer+"");
		bw.close();
		br.close();
	}

}