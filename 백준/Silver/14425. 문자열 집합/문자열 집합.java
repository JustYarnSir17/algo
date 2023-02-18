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
		StringTokenizer st = new StringTokenizer(str, " ");
		
		int n =Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		Map<String, Integer> map =new HashMap<>();
		int sum=0;
		for(int i=0;i<n;i++) {
			str=br.readLine();
			map.put(str, 1);
			
		}
		for(int i=0;i<m;i++) {
			str=br.readLine();
			if(map.containsKey(str)) {
				sum++;
			}
		}
		bw.write(String.valueOf(sum));
		bw.newLine();
		bw.close();
		br.close();
	}
}