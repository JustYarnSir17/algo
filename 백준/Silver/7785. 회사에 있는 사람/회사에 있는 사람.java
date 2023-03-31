import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashSet<String> set = new HashSet<>();
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			String str2 = st.nextToken();
			if(str2.equals("enter"))
				set.add(str);
			else
				set.remove(str);
		}
		List<String>list = new ArrayList<>(set);
		Collections.sort(list,Collections.reverseOrder());
		for(String s: list) {
			System.out.println(s.toString());
		}
		
		
	
	}
}