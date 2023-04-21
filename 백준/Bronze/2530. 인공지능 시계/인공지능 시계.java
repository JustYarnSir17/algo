import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h= Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		int s= Integer.parseInt(st.nextToken());
		int t=Integer.parseInt(br.readLine());
		int hh =t/3600;
		t%=3600;
		int mm = t/60;
		t%=60;
		h+=hh;
		m+=mm;
		s+=t;
		if(s>=60) {
			s-=60;
			m++;
		}
		if(m>=60) {
			h++;
			m-=60;
		}
		if(h>=24) {
			h%=24;
		}
		bw.write(h+" "+m+" "+s);
		bw.close();
		br.close();
			
	
		
		
	}
}