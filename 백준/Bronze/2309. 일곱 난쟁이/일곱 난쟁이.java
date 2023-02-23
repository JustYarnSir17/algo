import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int [] arr= new int [9];
		int sum=0;
		for(int i=0;i<9;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			sum+=arr[i];
		}
		Arrays.sort(arr);
		int x=0,y=0;
		com:
		for(int i=0;i<8;i++) {
			for(int j=i+1;j<9;j++) {
				if(sum-(arr[i]+arr[j])==100) {
					x=i;
					y=j;
					break com;
				}
			}
		}
		for(int i=0;i<9;i++) {
			if(i==x||i==y) {
				continue;
			}
			bw.write(String.valueOf(arr[i]));
			bw.newLine();
			
		}
		
		

		bw.close();
		br.close();

	}

}