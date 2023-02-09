import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int max=Integer.MIN_VALUE;
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int []arr = new int [n];
		int []sum= new int [n];
		str= br.readLine();
		st=new StringTokenizer(str," ");
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(i==0) {
				sum[i]=arr[i];
				
			}
			else {
				sum[i]=sum[i-1]+arr[i];
			}
		}
		for(int i=k-1;i<n;i++) {
			if(i==k-1) {
				max=Math.max(max, sum[i]);
			}
			else {
				max=Math.max(max,sum[i]-sum[i-k]);
				
			}
		}
		bw.write(String.valueOf(max));
		
		
		
		
		
		br.close();
		bw.close();
	}

}