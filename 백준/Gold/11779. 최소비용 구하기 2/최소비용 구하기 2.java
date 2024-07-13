import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static List<List<Node>> list = new ArrayList<>();
    static int[] d;
    static boolean[] v;
    static int[] count;
    static String[] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        d = new int[n];
        v = new boolean[n];
        count = new int[n];
        path = new String[n];
        Arrays.fill(path, "");
        
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to, cost, 0, ""));
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        dijkstra(a - 1);
        bw.write(d[b - 1] + "\n");
        bw.write(count[b - 1] + "\n");
        bw.write(path[b - 1].trim() + "\n");
        bw.close();
        br.close();
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0, 1, String.valueOf(start + 1)));
        
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (v[curr.to])
                continue;
            v[curr.to] = true;
            for (Node n : list.get(curr.to)) {
                if (!v[n.to] && d[curr.to] + n.cost < d[n.to]) {
                    d[n.to] = d[curr.to] + n.cost;
                    count[n.to] = curr.cnt + 1;
                    path[n.to] = curr.str + " " + (n.to + 1);
                    pq.add(new Node(n.to, d[n.to], curr.cnt + 1, curr.str + " " + (n.to + 1)));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int to;
    int cost;
    int cnt = 0;
    String str = "";

    Node(int to, int cost, int cnt, String str) {
        this.to = to;
        this.cost = cost;
        this.cnt = cnt;
        this.str = str;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.cost, other.cost);
    }
}