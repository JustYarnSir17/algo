import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static long a;
	static long b;
	static int cnt=0;
	static Queue<Long>q= new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a=Long.parseLong(st.nextToken());
		b=Long.parseLong(st.nextToken());
		int result=bfs();
		bw.write(String.valueOf(result));
		bw.close();
		br.close();
	}
	static int bfs() {
		q.add(a);
		while(!q.isEmpty()) {
			int size=q.size();
			for(int i=0;i<size;i++) {
				long tmp = q.poll();
				if(tmp==b) {
					return cnt+1;
				}
				if(tmp*2<=b)
					q.add(tmp*2);
				if(tmp*10+1<=b)
					q.add(tmp*10+1);
			}
			cnt++;
		}
		return -1;
	}
	
}