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
		int T= Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int n=Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();
			
			for(int i=0;i<n;i++) {
				String str =br.readLine();
				StringTokenizer st= new StringTokenizer(str, " ");
				st.nextToken();
				String tmp = st.nextToken();
				if(map.containsKey(tmp)) {
					map.put(tmp, map.get(tmp)+1);
					
				}
				else{
					map.put(tmp,1);
				}
				
			}
			int result= 1;
			for(int val:map.values()) {
				result*=(val+1);
			}
			result--;
			bw.write(String.valueOf(result));
			bw.newLine();
			
			
		}
		
		
		
		bw.close();
		br.close();
	}
}