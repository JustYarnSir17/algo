import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n= Integer.parseInt(br.readLine());
		int m=n*2-1;
		int mid=m/2;
		int idx=mid;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(j>=mid-idx&&j<=mid+idx) {
					bw.write("*");
				}
				else if(j<mid-idx){
					bw.write(" ");
				}
				else
					break;
				
			}
			idx--;
			bw.newLine();
		}
		
		bw.close();
		br.close();
	}

}