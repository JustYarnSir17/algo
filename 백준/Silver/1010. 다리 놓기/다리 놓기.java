import  java.util.*;
import java.io.*;

public class Main {

	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int [][] arr = new int [30][30];
		for(int i=1;i<30;i++) {
			arr[1][i]=i;
			arr[i][i]=1;
		}
		for(int i=2;i<30;i++) {
			for(int j = i+1;j<30;j++) {
				int sum=0;
				for(int k = 1;k<=j-i+1;k++) {
					sum+=arr[i-1][j-k];
				}
				arr[i][j]=sum;
			}
		}
		
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int time = 0;time<T;time++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			bw.write(arr[n][m]+"");
			bw.newLine();
			
			
		}
		bw.close();
		br.close();
	}

}