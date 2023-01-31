import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		int n =Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		int q;
		Map<String,Integer> map = new HashMap<>();
		String [] s= new String[n+1];
		for(int i=1;i<=n;i++) {
			String tmp = br.readLine();
			map.put(tmp, i);
			s[i]=tmp;
		}
		for(int i=0;i<m;i++) {
			String tmp = br.readLine();
			try {
				q=Integer.parseInt(tmp);
			}catch(NumberFormatException e) {
				q=-1;
			}
			if(q>=0) {
				bw.write(s[q]+"\n");
			}
			else {
				bw.write(map.get(tmp)+"\n");
			}
		}
		
		
		bw.close();
		br.close();
	}
}