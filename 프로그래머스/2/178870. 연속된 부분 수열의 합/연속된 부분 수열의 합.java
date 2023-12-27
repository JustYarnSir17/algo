import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0,sequence.length-1};
        int idx1=0;
        int idx2=0;
        int sum=sequence[0];
        while(idx2<sequence.length){
            if(sum==k){
                int tmp = idx2-idx1;
                if(answer[1]-answer[0]>tmp){
                    answer[0]=idx1;
                    answer[1]=idx2;
                }
                sum-=sequence[idx1];
                if(idx1<idx2){
                    ++idx1;
                }
                else{
                    sum-=sequence[idx2];
                    ++idx2;
                    ++idx1;
                    
                }
            }
            else if(sum<k){
                ++idx2;
                if(idx2<sequence.length){sum+=sequence[idx2];}
                else{
                    break;
                }
            }
            else {
                sum-=sequence[idx1];
                if(idx1<idx2){
                    ++idx1;
                }
                else{
                    sum-=sequence[idx2];
                    ++idx2;
                    ++idx1;
                    
                }
            }
            
            
        }
        return answer;
    }
}