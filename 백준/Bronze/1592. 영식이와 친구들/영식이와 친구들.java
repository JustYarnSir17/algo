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
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int [] arr= new int [n+1];
		
		int idx=1;
		int count=0;
		while(arr[idx]<m) {
			arr[idx]++;
			if(arr[idx]>=m) 
				break;
			count++;
			if(arr[idx]%2==0) {
				idx-=l;
				if(idx<1) {
					idx+=n;
				}
				
				
			}
			else {
				idx+=l;
				if(idx>n) {
					idx=idx%n;
				}
			}
			
			
		}
		bw.write(String.valueOf(count));
		br.close();
		bw.close();
	}

}