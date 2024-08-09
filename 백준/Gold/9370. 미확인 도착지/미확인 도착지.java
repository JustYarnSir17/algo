import java.io.*;
import java.util.*;

public class Main {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        
	        int T = Integer.parseInt(br.readLine());
	        for (int Time = 0; Time < T; Time++) {
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            int n = Integer.parseInt(st.nextToken());
	            int m = Integer.parseInt(st.nextToken());
	            int t = Integer.parseInt(st.nextToken());
	            int[] goal = new int[t];
	            
	            List<List<Node>> list = new ArrayList<>();
	            for (int i = 0; i <= n; i++) {
	                list.add(new ArrayList<>());
	            }
	            
	            st = new StringTokenizer(br.readLine());
	            int s = Integer.parseInt(st.nextToken());
	            int g = Integer.parseInt(st.nextToken());
	            int h = Integer.parseInt(st.nextToken());
	            
	            int gh = 0;
	            for (int i = 0; i < m; i++) {
	                st = new StringTokenizer(br.readLine());
	                int a = Integer.parseInt(st.nextToken());
	                int b = Integer.parseInt(st.nextToken());
	                int d = Integer.parseInt(st.nextToken());
	                if ((a == g && b == h) || (a == h && b == g)) {
	                    gh = d;
	                }
	                list.get(a).add(new Node(b, d));
	                list.get(b).add(new Node(a, d));
	            }
	            
	            for (int i = 0; i < t; i++) {
	                goal[i] = Integer.parseInt(br.readLine());
	            }
	            
	            // 세 번의 다익스트라 실행
	            int[] sDist = dijkstra(n, s, list);
	            int[] gDist = dijkstra(n, g, list);
	            int[] hDist = dijkstra(n, h, list);
	            
	            List<Integer> result = new ArrayList<>();
	            for (int x : goal) {
	                // s -> g -> h -> x 혹은 s -> h -> g -> x의 최소거리 비교
	                int route1 = sDist[g] + gh + hDist[x];
	                int route2 = sDist[h] + gh + gDist[x];
	                int shortest = sDist[x];
	                
	                if (route1 == shortest || route2 == shortest) {
	                    result.add(x);
	                }
	            }
	            
	            Collections.sort(result);
	            for (int r : result) {
	                bw.write(r + " ");
	            }
	            bw.newLine();
	        }
	        bw.flush();
	        bw.close();
	    }
	    
	    public static int[] dijkstra(int n, int start, List<List<Node>> list) {
	        int[] dist = new int[n + 1];
	        Arrays.fill(dist, 3000000);
	        dist[start] = 0;
	        
	        PriorityQueue<Node> pq = new PriorityQueue<>();
	        pq.offer(new Node(start, 0));
	        
	        while (!pq.isEmpty()) {
	            Node curr = pq.poll();
	            int c = curr.next;
	            int d = curr.d;
	            
	            if (dist[c] < d) continue;
	            
	            for (Node neighbor : list.get(c)) {
	                int next = neighbor.next;
	                int nextDist = d + neighbor.d;
	                
	                if (dist[next] > nextDist) {
	                    dist[next] = nextDist;
	                    pq.offer(new Node(next, nextDist));
	                }
	            }
	        }
	        
	        return dist;
	    }
	}

	class Node implements Comparable<Node> {
	    int next;
	    int d;
	    Node(int next, int d) {
	        this.next = next;
	        this.d = d;
	    }
	    @Override
	    public int compareTo(Node o) {
	        return this.d - o.d;
	    }
	}