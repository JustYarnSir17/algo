import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for(int i=citations.length-1;i>=0;i--){
            if(citations[i]>=answer+1){
                answer++;
            }
        }
        
        return answer;
    }
}