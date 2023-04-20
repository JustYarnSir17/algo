import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str= st.nextToken();
		int k=Integer.parseInt(st.nextToken());
		int size = str.length();
		int [] arr= new int[size];
		arr=getTable(str);
		long result = size - arr[size-1];
		result*=k;
		result+=arr[size-1];
		bw.write(String.valueOf(result));
		bw.close();
		br.close();
		
		
	}
	static int[] getTable(String pattern) {
		int [] arr= new int[pattern.length()];
		char[] pt = pattern.toCharArray();
		int j=0;
		for(int i=1;i<pattern.length();i++) {
			while(j>0&&pt[j]!=pt[i]) {
				j=arr[j-1];
			}
			if(pt[j]==pt[i]) {
				arr[i]=++j;
			}
		}
		return arr;
	}
}