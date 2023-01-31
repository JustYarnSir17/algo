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
		String str= br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<String, String> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			String tmp = br.readLine();
			StringTokenizer st1 = new StringTokenizer(tmp," ");
			String tmp1 = st1.nextToken();
			String tmp2 = st1.nextToken();
			map.put(tmp1, tmp2);
		}
		for(int i=0;i<m;i++) {
			String tmp = br.readLine();
			bw.write(map.get(tmp));
			bw.newLine();
		}
		
		
		
		br.close();
		bw.close();
	}
}