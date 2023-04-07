import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(br.readLine());
		String str=st.nextToken();
		int n=Integer.parseInt(st.nextToken());
		int result=0;
		int idx=1;
		for(int i=str.length()-1;i>=0;i--) {
			if(str.charAt(i)>='A'&&str.charAt(i)<='Z') {
			result+=(str.charAt(i)-'A'+10)*idx;}
			else {
				result+=(str.charAt(i)-'0')*idx;
			}
			idx*=n;
		}
		bw.write(String.valueOf(result));
		bw.close();
	}
}