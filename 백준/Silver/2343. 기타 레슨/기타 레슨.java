import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		String str=br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		int n =Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		int [] arr =new int [n];
		str= br.readLine();
		st=new StringTokenizer(str," ");
		int sum=0;
		int min=0;
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			sum+=arr[i];
			min=Math.max(min, arr[i]);
		}
		int result=Integer.MAX_VALUE;
		int left=min;
		int right = sum;
		while(left<=right) {
			int count=0;
			int mid = (right+left)/2;
			int tmp=0;
			int idx=0;
			
			while(idx<n) {
				
				if(tmp+arr[idx]>mid) {
					count++;
					tmp=0;
				}
				tmp+=arr[idx++];
			}
			if(tmp!=0) {
				count++;
			}
			if(count<=m) {
				result=Math.min(mid, result);
				right=mid-1;
			}
			else if(count>m) {
				left=mid+1;
			}
		}
		bw.write(String.valueOf(result));
		bw.close();
		br.close();
	}
}