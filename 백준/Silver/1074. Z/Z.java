import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int num=0;
	static void cal(int n, int r,int c) {
		if(n==1)
			return;
		if(r<n/2&&c<n/2) {
			cal(n/2,r,c);
			
		}
		else if(r<n/2&&c>=n/2) {
			num+=(n*n/4);
			cal(n/2,r,c-n/2);
		}
		else if(r>=n/2&&c<n/2) {
			num+=(n*n/4)*2;
			cal(n/2,r-n/2,c);
			
		}
		else {
			num+=(n*n/4)*3;
			cal(n/2,r-n/2,c-n/2);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int size = (int)Math.pow(2, n);
		cal(size,r,c);
			
		bw.write(String.valueOf(num));
		bw.close();
		br.close();
	}
}