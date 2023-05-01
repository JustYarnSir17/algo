import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		if(n>=12&&n<=16&&d==0) {
			bw.write("320");
		}
		else {
			bw.write("280");
		}
		bw.close();
		br.close();
	}
}