import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		for (int i = 0; i <= N; i++)
			graph[i] = new ArrayList<>();
		
		int[] time = new int[N+1];
		int[] inDegree = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			time[i] = T;
			int M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {
				int E = Integer.parseInt(st.nextToken());
				graph[E].add(i);
				inDegree[i]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) queue.add(i);
		}
		
		int[] res = new int[N+1];
		
		int ans = 0;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			res[cur] += time[cur];
			ans = Math.max(ans, res[cur]);
			for (int next : graph[cur]) {
				res[next] = Math.max(res[next], res[cur]);
				inDegree[next]--;
				if (inDegree[next] == 0) queue.add(next);
			}
		}
		
//		System.out.println(Arrays.toString(res));
		System.out.println(ans);
		
	}
}