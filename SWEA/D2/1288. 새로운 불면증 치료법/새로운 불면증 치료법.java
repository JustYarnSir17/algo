import java.io.*;
import java.util.*;


public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			
			int n = Integer.parseInt(br.readLine());
			int m=n;
			boolean []arr = new boolean [10];
			int idx=2;
			int cnt = 0;
			loop:
			while(cnt!=10) {
				int tmp =m;
				while(tmp>0) {
					if(!arr[tmp%10]) {
						arr[tmp%10]=true;
						cnt++;
						if(cnt==10) {
							break loop;
						}
					}
					tmp/=10;
				}
				m=n*idx;
				idx++;
			}
			bw.write("#"+t+" "+m);
			bw.newLine();
		}
		bw.close();
		
	}
}