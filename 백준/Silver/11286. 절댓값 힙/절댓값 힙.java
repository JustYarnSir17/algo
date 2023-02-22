import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				int A= Math.abs(a);
				int B = Math.abs(b);
				if(A>B) {
					return A-B;
					
				}
				else if( A==B) {
					if(a>b)return 1;
					else return -1;
				}
				else 
					return -1;
			}
		});
		for (int i = 0; i < n; i++) {
			int num= Integer.parseInt(br.readLine());
			if(num==0) {
				if(!q.isEmpty()) {
				bw.write(String.valueOf(q.poll()));
				bw.newLine();}
				else {
					bw.write("0");
					bw.newLine();
				}
				
			}
			else {
				q.offer(num);
			}
			
		}
		bw.close();
		br.close();

	}

}