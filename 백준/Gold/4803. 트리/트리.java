import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Integer>> list;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int idx = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            if (n == 0 && m == 0) break;

            list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);  // 양방향 간선 추가
            }

            int cnt = find();
            if (cnt == 0) {
                bw.write("Case " + idx + ": No trees.\n");
            } else if (cnt == 1) {
                bw.write("Case " + idx + ": There is one tree.\n");
            } else {
                bw.write("Case " + idx + ": A forest of " + cnt + " trees.\n");
            }

            idx++;
        }

        bw.close();
        br.close();
    }

    public static int find() {
        int cnt = 0;
        v = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!v[i]) {
                if (isTree(i)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static boolean isTree(int start) {
        Queue<int[]> q = new LinkedList<>();
        v[start] = true;
        q.offer(new int[]{start, -1});  // 노드와 부모 노드를 저장

        int nodes = 0;
        int edges = 0;
        boolean isCycle = false;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currNode = curr[0];
            int parentNode = curr[1];

            nodes++;

            for (int next : list.get(currNode)) {
                edges++;  // 간선 카운트 (양방향 간선이므로 나중에 나눌 것)

                if (!v[next]) {
                    v[next] = true;
                    q.offer(new int[]{next, currNode});
                } else if (next != parentNode) {  // 부모 노드가 아닌 다른 방문된 노드 발견 시 사이클 발생
                    isCycle = true;
                }
            }
        }

        // 트리일 조건: 간선 수가 노드 수 - 1이어야 하고 사이클이 없어야 함
        return (edges / 2 == nodes - 1) && !isCycle;
    }
}