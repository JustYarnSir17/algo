import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer NM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(NM.nextToken());
		int M = Integer.parseInt(NM.nextToken());
		
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		for (int i = 0; i <= N; i++)
			graph[i] = new ArrayList<>();
		
		int[] time = new int[N+1];
		int[] inDegree = new int[N+1];
		
		for (int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			graph[S].add(E);
			inDegree[E]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) queue.add(i);
		}
		
		int[] res = new int[N+1];
		int cnt = 0;
		while (!queue.isEmpty()) {
			cnt++;
			int size = queue.size();
			for (int  i = 0; i < size; i++) {
				int cur = queue.poll();
				res[cur] = cnt;
				for (int next : graph[cur]) {
					inDegree[next]--;
					if (inDegree[next] == 0) queue.add(next);
				}
			}
		}
		
		for (int i = 1; i <= N; i++) 
			sb.append(res[i] + " ");
		
		System.out.println(sb);
	}
}