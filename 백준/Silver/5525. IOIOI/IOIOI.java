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
		StringBuilder sb = new StringBuilder();
		sb.append("I");
		boolean fl = false;
		int count = 0;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			sb.append("OI");
		}
		String str = br.readLine();
		for (int i = 0; i < m; i++) {
			if (!fl) {
				if (str.charAt(i) == 'I') {

					if (i + sb.length() - 1 < m) {
						if (str.substring(i, i + sb.length()).equals(sb.toString())) {
							count++;
							fl = true;
							i=i+sb.length()-1;
						}
					}
				}
			}
			else {
				if(i+1<m) {
					if(str.charAt(i)=='O'&&str.charAt(i+1)=='I') {
						count++;
						i=i+1;
					}
					else {
						fl=false;
						i=i-1;
					}
				}
			}
		}
		bw.write(String.valueOf(count));

		bw.close();
		br.close();
	}
}