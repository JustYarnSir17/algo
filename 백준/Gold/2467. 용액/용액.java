import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st=  new StringTokenizer(br.readLine());
		int [] arr = new int [n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int left=0;
		int right =n-1;
		int min=Integer.MAX_VALUE;
		int result1=0,result2=0;
		while(left<right) {
			int sum=arr[left]+arr[right];
			if(min>=Math.abs(sum)) {
				min=Math.abs(sum);
				result1=left;
				result2=right;
			}
			if(sum>0) {
				right--;
			}
			else{
				left++;
			}
		}
		
		bw.write(arr[result1]+" "+arr[result2]);
		
		bw.close();
		br.close();
		
	}
}