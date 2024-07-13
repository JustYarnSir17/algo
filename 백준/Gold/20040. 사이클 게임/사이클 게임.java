import  java.util.*;
import java.io.*;

public class Main {
	static int [] arr;
	static int n;
	static int m;
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n =Integer.parseInt(st.nextToken());
		m =Integer.parseInt(st.nextToken());
		
		arr = new int [n];
		for(int i=0;i<n;i++) {
			arr[i]=i;
		}
		int answer=0;
		for(int i=0;i<m;i++) {
			st= new StringTokenizer(br.readLine());
			int tmp1=Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			if(identify(tmp1,tmp2)) {
				answer=i+1;
				break;
			}
			else {
				union(tmp1,tmp2);
			}
		}
		bw.write(answer+"");
		bw.close();
		br.close();
		
	}
	
	public static int find(int a) {
		if(arr[a]==a) {
			return a;
		}
		return arr[a]=find(arr[a]);
		
	}
	
	public static void union(int a,int b) {
		a=find(a);
		b=find(b);
		
		if(a<b) arr[b]=a;
		else arr[a]=b;
	}
	public static boolean identify(int a,int b) {
		a=find(a);
		b=find(b);
		if(a==b) {
			return true;
		}
		else {
			return false;
		}
	}
	
}