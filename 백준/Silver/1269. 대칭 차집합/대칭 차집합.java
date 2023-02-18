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
		StringTokenizer st = new StringTokenizer(str, " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		Map<Integer, Integer> mapA = new HashMap<>();
		Map<Integer, Integer> mapB = new HashMap<>();
		
		str= br.readLine();
		st = new StringTokenizer(str, " ");
		int []arr1=new int [a];
		int []arr2=new int [b];
		for(int i=0;i<a;i++) {
			arr1[i]=Integer.parseInt(st.nextToken());
			mapA.put(arr1[i], 1);
			
		}
		str= br.readLine();
		st = new StringTokenizer(str, " ");
		for(int i=0;i<b;i++) {
			arr2[i]=Integer.parseInt(st.nextToken());
			mapB.put(arr2[i], 1);
			
		}
		
		for(int i=0;i<a;i++) {
			if(mapB.containsKey(arr1[i])) {
				mapB.put(arr1[i], 0);
			}
		}
		for(int i=0;i<b;i++) {
			if(mapA.containsKey(arr2[i])) {
				mapA.put(arr2[i], 0);
			}
		}
		int sum=0;
		for(int i=0;i<a;i++) {
			if(mapA.get(arr1[i])==1) {
				sum++;
			}
		}
		for(int i=0;i<b;i++) {
			if(mapB.get(arr2[i])==1) {
				sum++;
			}
		}
		bw.write(String.valueOf(sum));
		
		bw.close();
		br.close();
	}
}