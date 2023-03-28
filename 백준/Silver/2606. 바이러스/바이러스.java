import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] list;
	static boolean[] v;
	static void dfs(int r) {
		v[r]=true;
		for(int i=0;i<list[r].size();i++) {
			if(v[list[r].get(i)]!=true) {
				dfs(list[r].get(i));
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int com = Integer.parseInt(br.readLine());
		list = new ArrayList[com+1];
		v= new boolean [com+1];
		for(int i=0;i<=com;i++) {
			list[i]=new ArrayList<Integer>();
		}
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			String str= br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int x= Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}
		dfs(1);
		int count=0;
		for(int i=2;i<=com;i++) {
			if(v[i]==true) {
				count++;
			}
		}
		bw.write(String.valueOf(count));
		bw.close();
		br.close();
	}
}