import java.io.*;
import java.util.*;

public class Main {
    
    static int n, L, R;
    static int[][] arr, tmp;
    static boolean[][] v;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        boolean tr = true;
        int cnt = 0;
        while (tr) {
            tmp = new int[n][n];
            for (int i = 0; i < n; i++) {
                System.arraycopy(arr[i], 0, tmp[i], 0, n);
            }
            v = new boolean[n][n];
            tr = find();
            if (tr) {
                cnt++;
            }
            for (int i = 0; i < n; i++) {
                System.arraycopy(tmp[i], 0, arr[i], 0, n);
            }
        }
        
        bw.write(cnt + "\n");
        bw.close();
        br.close();
    }
    
    public static boolean find() {
        boolean tr = false;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!v[i][j]) {
                    int popSum = bfs(i, j);
                    if (popSum > 0) {
                        tr = true;
                    }
                }
            }
        }
        
        return tr;
    }
    
    public static int bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        List<Node> list = new ArrayList<>();
        int sum = 0;
        q.offer(new Node(r, c));
        list.add(new Node(r, c));
        v[r][c] = true;
        sum += arr[r][c];
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                    continue;
                if (!v[nr][nc]) {
                    int diff = Math.abs(arr[curr.r][curr.c] - arr[nr][nc]);
                    if (diff >= L && diff <= R) {
                        v[nr][nc] = true;
                        sum += arr[nr][nc];
                        q.offer(new Node(nr, nc));
                        list.add(new Node(nr, nc));
                    }
                }
            }
        }
        
        if (list.size() > 1) {
            int newPop = sum / list.size();
            for (Node node : list) {
                tmp[node.r][node.c] = newPop;
            }
            return sum;
        }
        
        return 0;
    }
}

class Node {
    int r, c;
    Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}