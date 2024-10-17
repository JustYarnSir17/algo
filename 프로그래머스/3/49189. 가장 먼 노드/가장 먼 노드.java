import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edge.length;i++){
            int a= edge[i][0];
            int b= edge[i][1];
            list.get(a).add(b);
            list.get(b).add(a);
        }
        boolean v[]= new boolean[n+1];
        Queue<Integer> q= new LinkedList<>();
        q.offer(1);
        v[1]=true;
        int answer = 0;
        while(!q.isEmpty()){
            int size=q.size();
            answer=size;
            for(int s=0;s<size;s++){
                int curr = q.poll();
                for(int i=0;i<list.get(curr).size();i++){
                    int next = list.get(curr).get(i);
                    if(!v[next]){
                        q.offer(next);
                        v[next]=true;
                    }
                }
            }
        }
        return answer;
    }
}