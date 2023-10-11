import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        //goal = min +(second*2)
        int answer = 0;
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++){
            pq.add(scoville[i]);
        }
        while(pq.peek()<K){
            if(pq.size()<2){
                answer=-1;
                break;
            }
            int sco= pq.poll()+(2*pq.poll());
            pq.add(sco);
            answer++;
        }
        
        
        
        return answer;
    }
}