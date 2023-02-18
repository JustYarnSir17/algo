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
		int n =Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st= new StringTokenizer(str," ");
		int []arr=new int [n];
		for(int i=0;i<n;i++) {
			arr[i]=i+1;
		}
		int idx=0;
		for(int i=0;i<n;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			int tmp1=arr[i];
			for(int j=i;j>i-tmp;j--) {
				int tmp2=arr[j];
				arr[j]=arr[j-1];
			
			}
			arr[i-tmp]=tmp1;

			
			
		}
		for(int k=0;k<n;k++) {
			bw.write(arr[k]+" ");
		}
		bw.close();
		br.close();
	}
}