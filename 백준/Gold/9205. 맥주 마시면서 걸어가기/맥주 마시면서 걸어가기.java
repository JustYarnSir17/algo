import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int time = 0; time < T; time++) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Node[] stores = new Node[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                stores[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            Node goal = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            if (bfs(start, stores, goal)) {
                bw.write("happy\n");
            } else {
                bw.write("sad\n");
            }
        }
        bw.close();
        br.close();
    }

    static boolean bfs(Node start, Node[] stores, Node goal) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[stores.length];
        queue.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (distance(current, goal) <= 1000) {
                return true;
            }

            for (int i = 0; i < stores.length; i++) {
                if (!visited[i] && distance(current, stores[i]) <= 1000) {
                    visited[i] = true;
                    queue.add(stores[i]);
                }
            }
        }
        return false;
    }

    static int distance(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}

class Node {
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}