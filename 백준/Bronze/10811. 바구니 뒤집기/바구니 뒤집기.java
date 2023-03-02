import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str=br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int []arr= new int [n+1];
		for(int i=1;i<=n;i++) {
			arr[i]=i;
		}
		for(int k=0;k<m;k++) {
			str=br.readLine();
			st = new StringTokenizer(str," ");
			int i=Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			for(;i<=j;i++) {
				int tmp=arr[i];
				arr[i]=arr[j];
				arr[j]=tmp;
				j--;
			}
		}
		for(int i=1;i<=n;i++) {
			bw.write(arr[i]+" ");
		}
		

		bw.close();
		br.close();
	}
}