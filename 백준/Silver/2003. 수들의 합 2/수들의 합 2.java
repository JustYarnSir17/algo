import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int [] arr = new int [n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		int l=0;
		int r=0;
		int count=0;
		int sum=0;
		while(r<n) {
			sum+=arr[r++];
			if(sum==m) {
				++count;
				sum-=arr[l++];
			}
			else if(sum>m) {
				while(sum>m) {
					sum-=arr[l++];
				}
				if(sum==m) {
					++count;
					sum-=arr[l++];
				}
			}
		}
		bw.write(String.valueOf(count));
		bw.close();
		br.close();
	}
}