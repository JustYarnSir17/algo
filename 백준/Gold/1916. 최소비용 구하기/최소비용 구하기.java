import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int v, w;

		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

	}

	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static List<Node>[] adjList;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());

		adjList = new ArrayList[V+1];
		for (int i = 0; i <= V; i++) {
			adjList[i] = new ArrayList<>();

		}
		dist = new int[V+1];
		Arrays.fill(dist, INF);

		// 입력
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			// 유향 그래프

			adjList[A].add(new Node(B, W));// 인접리스트 노드 추가
			
		}
		StringTokenizer st=new StringTokenizer(br.readLine());
		int start= Integer.parseInt(st.nextToken());
		int end =Integer.parseInt(st.nextToken());
		dijkstra(start);
		
		bw.write(String.valueOf(dist[end]));
		bw.close();
		br.close();
		
	}

	private static void dijkstra(int st) {
		// TODO Auto-generated method stub
		boolean[] visited = new boolean[V+1];
		dist[st] = 0;// 시작 노드

		for (int i = 0; i <= V - 1; i++) {
			int min = INF;
			int idx = -1;

			// 선택하지 않은 정점 중 dist가 가장 짧은 것 선택
			for (int j = 0; j <= V; j++) {
				if (!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}

			if (idx == -1)
				break;// 선택할 것이 없다.

			visited[idx] = true;// 선택
			// 갱신
			for (int j = 0; j < adjList[idx].size(); j++) {
				Node curr = adjList[idx].get(j);

				if (!visited[curr.v] && dist[curr.v] > dist[idx] + curr.w) {
					dist[curr.v] = dist[idx] + curr.w;
				}
			}

		}

	}

}