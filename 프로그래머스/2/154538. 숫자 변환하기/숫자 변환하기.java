import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean [] arr = new boolean [1000001];
        arr[x]=true;
        int cnt=0;
        q.add(x);
        while(!q.isEmpty()){
            int idx = q.size();
            
            for(int i=0;i<idx;i++){
                int tmp = q.poll();
                if(tmp==y){
                    return cnt;
                }
                if(tmp>y){
                    continue;
                }
                if(tmp+n<=1000000&&!arr[tmp+n]){
                    arr[tmp+n]=true;
                    q.add(tmp+n);
                }
                if(tmp*2<=1000000&&!arr[tmp*2]){
                    arr[tmp*2]=true;
                    q.add(tmp*2);
                }
                if(tmp*3<=1000000&&!arr[tmp*3]){
                    arr[tmp*3]=true;
                    q.add(tmp*3);
                    
                }
            }
            ++cnt;
            
        }
        int answer = -1;
        return answer;
    }
}