import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int m;
	static int [] arr;
	static int [] str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr= new int [n];
		str=new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		comb(0,0);
		bw.write(sb.toString());
		bw.close();
		br.close();
		
		
	
	}
	private static void comb(int idx, int cnt) {
		// TODO Auto-generated method stub
		if(cnt==m) {
			for(int i=0;i<m;i++) {
				sb.append(str[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		int a=0;
		for(int i=idx;i<n;i++) {
			if(a==arr[i]) continue;
			str[cnt]=arr[i];
			comb(i,cnt+1);
			a=arr[i];
			
		}
		
	}
}