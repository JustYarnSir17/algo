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
		String str= br.readLine();
		StringBuilder sb= new StringBuilder();
		int r=0;
		int c=0;
		for(int i=1;i<=str.length();i++) {
			for(int j=1;j<=str.length();j++) {
				if(i*j==str.length()) {
					if(j<=i) {
						if(j>r) {
							r=j;
							c=i;
						}
					}
				}
			}
		}
		int idx=0;
		char [][]arr=new char [c][r];
		for(int i=0;i<c;i++) {
			for(int j=0;j<r;j++){
				arr[i][j]=str.charAt(idx++);
			}
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				sb.append(arr[j][i]);
			}
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}