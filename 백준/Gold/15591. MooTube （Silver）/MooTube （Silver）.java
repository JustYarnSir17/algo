import java.io.*;
import java.util.*;

public class Main {
    static int n, q;
    static int[][] arr;
    static List<List<Node>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int u = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, u));
            list.get(b).add(new Node(a, u));  // 양방향 간선
        }

        // 다익스트라로 각 노드의 최대 가중치를 계산
        for (int i = 0; i < n; i++) {
            dijkstra(i);
        }
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(arr[i][j]==Integer.MAX_VALUE) {
        			arr[i][j]=0;
        		}
        	}
        }
        // 쿼리 처리
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken()) - 1;

            // k 이상인 간선의 수를 세기
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[v][j] >= k) {
                    cnt++;
                }
            }
            bw.write(cnt + "\n");
        }

        bw.close();
        br.close();
    }

    // 다익스트라 알고리즘
    static void dijkstra(int start) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[start] = Integer.MAX_VALUE;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Node(start, Integer.MAX_VALUE));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.next;
            int currentDist = current.u;

            if (dist[currentNode] > currentDist) continue;

            for (Node neighbor : list.get(currentNode)) {
                int nextNode = neighbor.next;
                int weight = Math.min(currentDist, neighbor.u);

                if (dist[nextNode] < weight) {
                    dist[nextNode] = weight;
                    pq.add(new Node(nextNode, weight));
                }
            }
        }

        // dist 배열에 저장된 값들을 arr 배열에 반영
        for (int i = 0; i < n; i++) {
            arr[start][i] = dist[i];
        }
    }

    // 노드 클래스
    static class Node implements Comparable<Node> {
        int next;
        int u;

        Node(int next, int u) {
            this.next = next;
            this.u = u;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.u, other.u);
        }
    }
}