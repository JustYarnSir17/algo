import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static Stack<Integer> stack = new Stack<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static void dfs(int cnt) throws IOException{
		if(cnt == m ) {
			for(int i=0;i<stack.size();i++) {
				bw.write(stack.get(i)+" ");
			}
			bw.newLine();
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(stack.isEmpty()) {
				stack.push(arr[i]);
				dfs(cnt+1);
				stack.pop();
			}
			else if(!stack.isEmpty()&&stack.peek()<=arr[i]) {
				stack.push(arr[i]);
				dfs(cnt+1);
				stack.pop();
				
			}
		}
		
		
	}
	

	public static void main(String[] args) throws IOException {

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		dfs(0);
		bw.close();
		br.close();

	}

}