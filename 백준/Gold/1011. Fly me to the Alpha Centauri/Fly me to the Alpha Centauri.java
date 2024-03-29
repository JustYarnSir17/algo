import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());
			int d =y-x;
			int max= (int)Math.sqrt(d);
			
			if(max==Math.sqrt(d)) {
				bw.write(2*max-1+"");
			}
			else if(d<=Math.pow(max, 2)+max) {
				bw.write(2*max+"");
			}
			else {
				bw.write(2*max+1+"");
			}
			bw.newLine();
			
			
			
			
		}
		bw.close();br.close();
	}
	
	
}