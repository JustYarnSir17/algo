import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<>();
		String str= br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		for(int i=0;i<n;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(!set.contains(tmp)) {
				set.add(tmp);
			}
		}
		for(int i=-1000;i<=1000;i++) {
			if(set.contains(i)) {
				bw.write(i+" ");
			}
		}
		
		bw.close();
		br.close();
	}
}