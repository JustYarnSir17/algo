import  java.util.*;
import java.io.*;

public class Main {
	public static void main(String [] args) throws IOException{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new  OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		boolean [] arr= new boolean[1001];
		int cnt =0;
		
		for(int i=2;i<=n;i++) {
			for(int j =1;j*i<=n;j++) {
				if(!arr[i*j]) {
					arr[i*j]=true;
					++cnt;
					if(cnt==k) {
						bw.write(i*j+"");
						bw.close();
						br.close();
						return;
					}
				}
			}
		}
		return;
		
	}

}