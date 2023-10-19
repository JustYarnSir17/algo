import java.util.*;
import java.math.*;
class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int max=0;
        int min=1001;
        for(int i=0;i<2;i++){
            max=Math.max(max,sides[i]);
            min=Math.min(min,sides[i]);
        }
        for(int i=1;i<=max;i++){
            if(max>=min+i){
                continue;
            }
            else{
                answer++;
            }
        }
        for(int i=max+1;i<max+min;i++){
            answer++;
        }
        
        return answer;
    }
}