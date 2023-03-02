import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr;
	static int sum1=0;
	static int sum2=0;
	static int sum3=0;
	
	static void cal(int size,int r,int c) {
		
		int s0=0;
		int s1=0;
		int s2=0;
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				if(arr[i][j]==-1)
					s0++;
				else if (arr[i][j]==0)
					s1++;
				else s2++;
			}
		}
		int max= size*size;
		if(s0==max) {
			sum1++;
			return;
			
		}
		else if(s1==max) {
			sum2++;
			return;
		}
		else if(s2==max) {
			sum3++;
			return;
		}
		if(s0<max&&s1<max&&s2<max) {
			int tmp = size/3;
			int [] dr = {r,r+tmp,r+(2*tmp)};
			int [] dc = {c,c+tmp,c+(2*tmp)};
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					cal(tmp,dr[i],dc[j]);
				}
			}
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cal(n,0,0);
		bw.write(sum1+"\n"+sum2+"\n"+sum3);
		
		bw.close();
		br.close();
	}
}