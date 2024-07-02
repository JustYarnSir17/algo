import  java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new  OutputStreamWriter(System.out));
	static int n;
	static int m;
	static int [] num;
	static int [] val;
	static int idx=0;
	public static void main(String [] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num= new int [n];
		val=new int [m];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			num[i]=tmp;
		}
		Arrays.sort(num);
		calculate(0);
		bw.close();
		br.close();
		
		
	}
	
	public static void calculate(int cnt) throws IOException {
		if(cnt==m) {
			for(int i=0;i<val.length;i++) {
				bw.write(val[i]+" ");
			}
			bw.newLine();
			return;
		}
		
		for(int i=0;i<n;i++) {
				val[idx++]=num[i];
				calculate(cnt+1);
				--idx;
			
			
		}
	}

}