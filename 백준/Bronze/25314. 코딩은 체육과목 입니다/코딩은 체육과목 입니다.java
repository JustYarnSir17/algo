import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb= new StringBuilder();
		
		int n =Integer.parseInt(br.readLine());
		int m=n/4;
		if(n%4!=0) {
			m++;
		}
		for(int i=0;i<m;i++) {
			sb.append("long ");
		}
		sb.append("int");
		bw.write(sb.toString());
		
		bw.close();
		br.close();
	}
}