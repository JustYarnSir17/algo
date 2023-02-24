import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static boolean []v;
	static int[] arr;
	static Stack<Integer> stack = new Stack<>();
	static void Print() {
		for(int i=0;i<stack.size();i++) {
			System.out.print(stack.get(i)+" ");
			
		}
		System.out.println();
		return;
	}
	
	static void dfs(int cnt) {
	
		if(cnt==m) {
			Print();
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(v[i])continue;
			v[i]=true;
			stack.push(arr[i]);
			dfs(cnt+1);
			stack.pop();
			v[i]=false;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		StringTokenizer st =new StringTokenizer(str," ");
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr= new int [n];
		v=new boolean [n];
		for(int i=0;i<n;i++) {
			arr[i]=i+1;
		}
		dfs(0);
		
		
		
		bw.close();
		br.close();

	}

}