import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Pair> q = new LinkedList<>();
        
        int sum=0;
        int idx=0;
        int time=0;
        while(idx<truck_weights.length){
            
            if(q.isEmpty()){
                sum+=truck_weights[idx];
                q.add(new Pair(truck_weights[idx++],++time));
                System.out.println(time+" "+sum);
            }
            else{
                if(sum+truck_weights[idx]<=weight&&q.size()<bridge_length){
                    sum+=truck_weights[idx];
                    q.add(new Pair(truck_weights[idx++],++time));
                    System.out.println(time+" "+sum);
                    if(time-q.peek().time==bridge_length){
                        sum-=q.peek().weight;
                        q.poll();
                    }
                }
                else{
                    int tmp = time-q.peek().time;
                    int sub= bridge_length-tmp;
                    time+=sub-1;
                    sum-=q.peek().weight;
                    q.poll();
                }
            }
        }
        Pair tmp=new Pair(0,0);
        while(!q.isEmpty()){
            tmp=q.poll();
        }
        if(tmp.time!=0){
            time = tmp.time+bridge_length;
        }
        answer=time;
        return answer;
    }
    
}
class Pair{
    int weight;
    int time;
    Pair(int weight,int time){
        this.weight=weight;
        this.time=time;
    }
}