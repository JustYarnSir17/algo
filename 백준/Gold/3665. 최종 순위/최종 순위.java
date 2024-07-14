import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] inDegree = new int[n + 1];
            boolean[][] adj = new boolean[n + 1][n + 1];
            int[] lastYear = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                lastYear[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    adj[lastYear[i]][lastYear[j]] = true;
                    inDegree[lastYear[j]]++;
                }
            }

            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (adj[a][b]) {
                    adj[a][b] = false;
                    adj[b][a] = true;
                    inDegree[a]++;
                    inDegree[b]--;
                } else {
                    adj[a][b] = true;
                    adj[b][a] = false;
                    inDegree[a]--;
                    inDegree[b]++;
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }

            List<Integer> result = new ArrayList<>();
            boolean isDetermined = true;

            for (int i = 0; i < n; i++) {
                if (queue.isEmpty()) {
                    isDetermined = false;
                    break;
                }
                if (queue.size() > 1) {
                    isDetermined = false;
                    break;
                }

                int curr = queue.poll();
                result.add(curr);
                for (int j = 1; j <= n; j++) {
                    if (adj[curr][j]) {
                        inDegree[j]--;
                        if (inDegree[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
            }

            if (!isDetermined) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int team : result) {
                    System.out.print(team + " ");
                }
                System.out.println();
            }
        }
    }
}