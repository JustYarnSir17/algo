import java.util.*;
import java.io.*;

public class Main {
	static int cnt=0;
	static List<Integer>list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String T= br.readLine();
		String p = br.readLine();
		
		KMP(T,p);
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i)-p.length()+2+" ");
		}
		bw.write(cnt+"\n"+sb.toString());
		bw.close();
		br.close();
		
		
	}
	static int [] getTable(String pattern) {
		int [] arr= new int [pattern.length()];
		char[] pt = pattern.toCharArray();
		int j=0;
		for(int i=1;i<pattern.length();i++) {
			while(j>0&&pt[i]!=pt[j]) {
				j=arr[j-1];
			}
			if(pt[i]==pt[j]) {
				arr[i]=++j;
			}
		}
		return arr;
	}
	static void KMP(String str, String pattern) {
		int[] arr = getTable(pattern);
		char[]text = str.toCharArray();
		char[] pt=pattern.toCharArray();
		int j=0;
		for(int i=0;i<text.length;i++) {
			while(j>0&&text[i]!=pt[j])
				j=arr[j-1];
			if(text[i]==pt[j]) {
				if(j==pattern.length()-1) {
					cnt++;
					j=arr[j];
					list.add(i);
				}
				else {
					j++;
				}
			}
		}
		
	}
}