import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static Stack<Integer> stack = new Stack<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		int n =Integer.parseInt(st.nextToken());
		int k =Integer.parseInt(st.nextToken());
		int idx=0;
		int result=0;
		for(int i=1;i<=n;i++) {
			if(n%i==0) {
				idx++;
				if(idx==k)
				{
					result=i;
					break;}
			}
		}
		bw.write(String.valueOf(result));
		
		bw.close();
		br.close();
	}

}