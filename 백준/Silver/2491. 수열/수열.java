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
		int n = Integer.parseInt(br.readLine());
		String str= br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		int [] arr= new int [n];
		int [] indp= new int [n];
		int [] dedp= new int [n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			indp[i]=1;
			dedp[i]=1;
		}
		for(int i=1;i<n;i++) {{
				if(arr[i-1]<=arr[i]) {
					indp[i]=Math.max(indp[i], indp[i-1]+1);
				}
				if(arr[i-1]>=arr[i]) {
					dedp[i]=Math.max(dedp[i],dedp[i-1]+1);
				}
			}
		}
		int max=0;
		for(int i=0;i<n;i++) {
			max=Math.max(max, indp[i]);
			max=Math.max(max, dedp[i]);
			
		}
		bw.write(String.valueOf(max));
		
		

		bw.close();
		br.close();

	}

}