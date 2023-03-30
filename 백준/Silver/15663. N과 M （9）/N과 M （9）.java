import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static boolean[]visited;
	static int [] arr,p;
	static LinkedHashSet<String> ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans=new LinkedHashSet<>();
		visited= new boolean[n];
		arr= new int [n];
		p=new int [m];
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		perm(0);
		ans.forEach(System.out::println);
	}
	static void perm(int cnt) {
		
		if(cnt==m) {
			StringBuilder sb= new StringBuilder();
			for(int a:p) {
				sb.append(a).append(' ');
			}
			ans.add(sb.toString());
			return;
		}
		for(int i=0;i<n;i++) {
			if(visited[i])
				continue;	
			visited[i]=true;
			p[cnt]=arr[i];
			perm(cnt+1);
			visited[i]=false;
		}
	}
}