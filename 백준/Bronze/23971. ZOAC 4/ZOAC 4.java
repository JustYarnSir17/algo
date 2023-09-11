import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h= Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		m+=1;
		n+=1;
		
		int row,col;
		if(w%m!=0) {
			row= w/m+1;
			
		}
		else {
			row=w/m;
		}
		if(h%n!=0) {
			col=h/n+1;
		}
		else {
			col=h/n;
		}
		int count = row*col;
		bw.write(String.valueOf(count));
		bw.close();
		br.close();
		
	}
}