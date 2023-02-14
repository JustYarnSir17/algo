import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n =Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		int count=1;
		int cou=0;
		int num=str.length();
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='S') {
				count++;
			}
			else if(str.charAt(i)=='L') {
				i++;
				count++;
			}
		}
		num=Math.min(num, count);
		bw.write(String.valueOf(num));
		br.close();
		bw.close();
	}

}