import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer>q = new LinkedList<>();
        Queue<Integer>s = new LinkedList<>();
        ArrayList<Integer>list=new ArrayList<>();
        int day=0;
        for(int i=0;i<progresses.length;i++){
            q.offer(progresses[i]);
            s.offer(speeds[i]);
            
        }
        while(!q.isEmpty()){
            int tmp = 100- q.peek();
            tmp -= s.peek()*day;
            if(tmp%s.peek()==0){
                day+=tmp/s.peek();
            }
            else{
                day+=tmp/s.peek()+1;
            }
            int idx=0;
            while(!q.isEmpty()&&100-q.peek()<=s.peek()*day){
                q.poll();
                s.poll();
                ++idx;
            }
            if(idx!=0)
                list.add(idx);
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
}