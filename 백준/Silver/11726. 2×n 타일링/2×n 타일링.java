import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int []arr;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n=Integer.parseInt(br.readLine());
		arr = new int [10001];
		arr[1]=1;
		arr[2]=2;
		for(int i=3;i<=1000;i++) {
			arr[i]=(arr[i-1]+arr[i-2])%10007;
		}
		bw.write(String.valueOf(arr[n]));
		bw.close();
		br.close();
	}
	
}