import java.util.*;
import java.io.*;

public class Main {
	public static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		
		sb.append((int)(Math.pow(2,n)-1)).append('\n');
		
		hanoi(n,1,2,3);
		System.out.println(sb);
		
		
	}
	public static void hanoi(int n, int l, int m, int r) {
		if(n==1) {
			sb.append(l+" "+r+"\n");
			return;
		}
		
		
		hanoi(n-1,l,r,m);
		sb.append(l+" "+r+'\n');
		
		hanoi(n-1,m,l,r);
	}
}