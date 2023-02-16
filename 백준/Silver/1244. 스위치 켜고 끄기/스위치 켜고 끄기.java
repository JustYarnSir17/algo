import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		String str= br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		int [] arr= new int [n+1];
		for(int i=1;i<=n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int p =Integer.parseInt(br.readLine());
		for(int i=0;i<p;i++) {
			str=br.readLine();
			st=new StringTokenizer(str," ");
			int f= Integer.parseInt(st.nextToken());
			int a= Integer.parseInt(st.nextToken());
			if(f==1) {
				for(int j=1;j<=n;j++) {
					if(j%a==0) {
						arr[j]=Math.abs(arr[j]-1);
					}
				}
				
			}
			else {
				arr[a]=Math.abs(arr[a]-1);
				int idx =1;
				while(true) {
					if(a-idx<=0||a+idx>n)
						break;
					if(arr[a+idx]==arr[a-idx]) {
						arr[a+idx]=Math.abs(arr[a+idx]-1);
						arr[a-idx]=Math.abs(arr[a-idx]-1);
					}
					else {
						break;
					}
					idx++;
				}
			}
		}
		for(int i=1;i<n;i++) {
			bw.write(arr[i]+" ");
			if(i%20==0) {
				bw.write("\n");
			}
		}
		bw.write(String.valueOf(arr[n]));
		
		bw.close();
		br.close();
	}
}