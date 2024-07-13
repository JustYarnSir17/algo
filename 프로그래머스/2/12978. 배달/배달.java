import java.util.*;

class Solution {
    static List<List<Node>> list = new ArrayList<>();
    static int n;
    static int [] d;
    static boolean[] v;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        n=N;
        d=new int[n];
        v=new boolean[n];
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        Arrays.fill(d,Integer.MAX_VALUE);
        for(int i=0;i<road.length;i++){
            int a= road[i][0]-1;
            int b= road[i][1]-1;
            int cost=road[i][2];
            list.get(a).add(new Node(b,cost));
            list.get(b).add(new Node(a,cost));
        }
        dijkstra(0);
        for(int i=0;i<n;i++){
            if(d[i]<=K){
               ++answer;
            }
        }
        return answer;
    }
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        d[start]=0;
        while(!pq.isEmpty()){
            Node node= pq.poll();
            int curr= node.idx;
            if(v[curr])
                continue;
            v[curr]=true;
            for(Node n: list.get(curr)){
                if(!v[n.idx]&&d[curr]+n.cost<d[n.idx]){
                    
                    d[n.idx]=d[curr]+n.cost;
                    pq.add(new Node(n.idx,d[n.idx]));
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int idx;
    int cost;
    Node(int idx, int cost){
        this.idx=idx;
        this.cost=cost;
    }
    @Override
    public int compareTo(Node other){
        return Integer.compare(this.cost,other.cost);
    }
    
}