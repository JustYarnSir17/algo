import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int count=Integer.MAX_VALUE;
	static StringBuilder sb = new StringBuilder();
	static List<Integer>list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		sb.append(n+" ");
		list.add(n);
		cal(n,0);
		bw.write(count+"\n"+sb.toString());
		bw.close();
		br.close();
		
	}
	static void cal(int n,int cnt) {
		int tmp=n;
		if(cnt>count)
			return;
		if(n==1) {
			if(count>cnt) {
				sb.delete(0, sb.length());
				for(int i=0;i<list.size();i++) {
					sb.append(list.get(i)+" ");
				}
				count=cnt;
			}
			return;
		}
		
		if(n%3==0) {
			n/=3;
			list.add(n);
			cal(n,cnt+1);
			list.remove(list.size()-1);
			n=tmp;
			
		}
		if(n%2==0) {
			n/=2;
			list.add(n);
			cal(n,cnt+1);
			list.remove(list.size()-1);
			n=tmp;
		}
		n--;
		list.add(n);
		cal(n,cnt+1);
		list.remove(list.size()-1);
		n=tmp;
	}
	
}