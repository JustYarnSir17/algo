import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int x;
    static ArrayList<ArrayList<Node>> graph;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken()) - 1;

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, weight));
        }

        int[] distToX = dijkstra(x, n);
        int maxTime = 0;

        for (int i = 0; i < n; i++) {
            if (i == x) continue;
            int[] distFromI = dijkstra(i, n);
            maxTime = Math.max(maxTime, distFromI[x] + distToX[i]);
        }

        bw.write(String.valueOf(maxTime));
        bw.close();
        br.close();
    }

    static int[] dijkstra(int start, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curr = node.index;

            if (visited[curr]) continue;
            visited[curr] = true;

            for (Node neighbor : graph.get(curr)) {
                if (!visited[neighbor.index] && dist[curr] + neighbor.cost < dist[neighbor.index]) {
                    dist[neighbor.index] = dist[curr] + neighbor.cost;
                    pq.add(new Node(neighbor.index, dist[neighbor.index]));
                }
            }
        }

        return dist;
    }
}

class Node implements Comparable<Node> {
    int index;
    int cost;

    Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.cost, other.cost);
    }
}