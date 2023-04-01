import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			long n=Long.parseLong(br.readLine());
			BigInteger b =new BigInteger(String.valueOf(n));
			if(b.isProbablePrime(10)) {
				bw.write(String.valueOf(n));
				bw.newLine();
			}
			else {
				bw.write(String.valueOf(b.nextProbablePrime()));
				bw.newLine();
			}
		}
		bw.close();
		br.close();
		
	}
	
	
}