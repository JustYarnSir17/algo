import  java.util.*;
import java.io.*;

public class Main {

	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int [] arr= new int [n];
		
		StringTokenizer st = new  StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			
		}
		Arrays.sort(arr);
		int idx1=0;
		int idx2=n-1;
		int sum = Math.abs(arr[n-1]+arr[0]);
		int x=0;
		int y=n-1;
		
		while(idx1<idx2) {
			int tmp = arr[idx1]+arr[idx2];
			if(tmp ==0) {
				x=idx1;
				y=idx2;
				break;
			}
			else if(tmp>0) {
				if(tmp<sum) {
					sum=tmp;
					x=idx1;
					y=idx2;
				}
				--idx2;
			}
			else if(tmp<0){
				if(Math.abs(tmp)<sum) {
					sum=Math.abs(tmp);
					x=idx1;
					y=idx2;
				}
				++idx1;
			}
			
		}
		
	
		bw.write(arr[x]+" "+arr[y]);
		bw.close();
		br.close();
	}

}