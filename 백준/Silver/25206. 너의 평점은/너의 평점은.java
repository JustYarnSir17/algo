import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashMap<String,Double> map = new HashMap<String,Double>();
		
		map.put("A+", 4.5);
		map.put("A0", 4.0);
		map.put("B+", 3.5);
		map.put("B0", 3.0);
		map.put("C+", 2.5);
		map.put("C0", 2.0);
		map.put("D+", 1.5);
		map.put("D0", 1.0);
		map.put("F", 0.0);
		map.put("P", 0.0);
		
		double sum=0;
		double sub_sum=0;
		for(int i=0;i<20;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			double sub =Double.parseDouble(st.nextToken());
			String str = st.nextToken();
			if(str.equals("P")) {
				continue;
			}
			sub_sum+=sub;
			double score = map.get(str);
			double result = sub*score;
			sum+=result;
		}
		sum/=sub_sum;
		System.out.printf("%.6f",sum);
		
		
	}
}