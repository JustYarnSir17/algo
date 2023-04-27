import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] arr;
	static boolean[][]v;
	static int [] dr = {1,-1,0,0};
	static int [] dc = {0,0,1,-1};
	static HashSet<Character> set = new HashSet<>();
	static int result=1;
	static int max=1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		arr= new char [R][C];
		v=new boolean[R][C];
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		set.add(arr[0][0]);
		v[0][0]=true;
		dfs(0,0);
		
		bw.write(String.valueOf(max));
		bw.close();
		br.close();
		
	}
	static void dfs(int r,int c) {
		for(int i=0;i<4;i++) {
			int nr= r+dr[i];
			int nc= c+dc[i];
			if(nr<0||nr>=R||nc<0||nc>=C)
				continue;
			if(!set.contains(arr[nr][nc])) {
				if(!v[nr][nc]) {
					v[nr][nc]=true;
					set.add(arr[nr][nc]);
					result++;
					max=Math.max(result, max);
					dfs(nr,nc);
					set.remove(arr[nr][nc]);
					result--;
					v[nr][nc]=false;
					
				}
				
				
			}
		}
	}
}