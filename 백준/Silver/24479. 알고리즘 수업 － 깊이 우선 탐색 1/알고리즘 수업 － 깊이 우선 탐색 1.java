import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
		static ArrayList<Integer>[] list;
		static boolean []v;
		static int [] arr;
		static int num=1;
		
		static void dfs(ArrayList<Integer>[] list,int r) {
			
			arr[r]=num++;
			for(int num: list[r]) {
				if(!v[num]) {
					v[num]=true;
				dfs(list,num);}
			}
		}
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		String str= br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		
		int n =Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		arr=new int [n+1];
		list = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		v= new boolean[n+1];
		for(int i=0;i<m;i++) {
			str=br.readLine();
			st=new StringTokenizer(str," ");
			int from= Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		for(int i=1;i<=n;i++) {
			Collections.sort(list[i]);
		}
		v[r]=true;
		dfs(list,r);
		for(int i=1;i<=n;i++) {
			bw.write(String.valueOf(arr[i]));
			bw.newLine();
		}
		bw.close();
		br.close();
	}
}