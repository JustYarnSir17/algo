import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String p = br.readLine();
		while (!p.equals(".")) {
			int size= p.length();
			int [] arr =new int [size];
			arr=getTable(p);
			if(size%(size-arr[size-1])==0) {
				bw.write(size/(size-arr[size-1])+"");
				
			}
			else {
				bw.write("1");
			}
			bw.newLine();
			p=br.readLine();

		}
		bw.close();
		br.close();

	}

	static int[] getTable(String p) {
		int[] arr = new int[p.length()];
		char[] pt = p.toCharArray();
		int j = 0;
		for (int i = 1; i < p.length(); i++) {
			while (j > 0 && pt[i] != pt[j]) {
				j = arr[j - 1];

			}
			if (pt[i] == pt[j])
				arr[i] = ++j;
		}
		return arr;
	}

}