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
		StringTokenizer st = new StringTokenizer(str," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int [] arr= new int [n];
		int idx=0;
		int count=0;
		for(int i=0;i<n;i++) {
			String tmp = br.readLine();
			arr[i]=Integer.parseInt(tmp);
			if(k>=arr[i]) {
				idx=i;
			}
		}
		while(k>0) {
			count+= k/arr[idx];
			k=k-arr[idx]*(k/arr[idx]);
			idx--;
		}
		bw.write(String.valueOf(count));
		br.close();
		bw.close();
	}
}