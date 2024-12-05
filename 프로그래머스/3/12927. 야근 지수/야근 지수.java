import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<works.length;i++){
            pq.offer(works[i]);
        }
        for(int i=0;i<n;i++){
            if(!pq.isEmpty()){
                int tmp =pq.poll();
                tmp--;
                if(tmp>0){
                    pq.offer(tmp);
                }
            }
            else{
                break;
            }
        }
        while(!pq.isEmpty()){
            long tmp = pq.poll();
            tmp*=tmp;
            answer+=tmp;
        }
        return answer;
    }
}