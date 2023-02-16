import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		int r=1;
		int sum=1;
		int idx=1;
		while(true) {
			if(n<=sum) {
				break;
			}
			else {
				r++;
				sum+=idx*6;
				idx++;
			}
			
		}
		bw.write(String.valueOf(r));
		bw.close();
		br.close();
	}
}