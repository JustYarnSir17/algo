import  java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new  OutputStreamWriter(System.out));
	static int n;
	static boolean [] arr;
	static int [] per;
	static int idx=0;
	public static void main(String [] args) throws IOException{
		n = Integer.parseInt(br.readLine());
		arr = new boolean [n+1];
		per= new int [n];
		permutation(0);
		bw.close();
		br.close();
	}
	
	public static void permutation(int cnt) throws IOException {
		if(cnt==n) {
			for(int i=0;i<per.length;i++) {
				bw.write(per[i]+" ");
			}
			bw.newLine();
		}
		
		for(int i=1;i<=n;i++) {
			if(!arr[i]) {
				per[idx++]=i;
				arr[i]=true;
				permutation(cnt+1);
				arr[i]=false;
				--idx;
			}
			
			
		}
	}

}