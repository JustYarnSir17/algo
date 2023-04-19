import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n =Integer.parseInt(br.readLine());
		String p = br.readLine();
		int [] arr ;
		arr=getTable(p);
		bw.write(n-arr[n-1]+"");
		
	
		bw.close();
		br.close();
		
		
	}
	static int [] getTable(String p) {
		int [] arr = new int [p.length()];
		char[] pt = p.toCharArray();
		int j=0;
		for(int i=1;i<p.length();i++) {
			while(j>0&&pt[i]!=pt[j]) {
				j=arr[j-1];
				
			}
			if(pt[i]==pt[j])
				arr[i]=++j;
		}
		return arr;
	}
	
}