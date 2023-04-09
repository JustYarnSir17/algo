import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long result=1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n=Integer.parseInt(br.readLine());
		if(n==0) {
			bw.write("1");
		}
		else {
			cal(n);
			bw.write(String.valueOf(result));
		}
		bw.close();
		br.close();
		
	}
	static void cal(int n) {
		if(n==1)
			return;
		result*=n;
		cal(n-1);
	}
}