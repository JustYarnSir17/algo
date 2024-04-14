import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer>set = new HashSet<>();
        for(int i=0;i<elements.length;i++){
            int tmp=0;
            int idx=i;
            int cnt=0;
            for(int j=0;j<elements.length;j++){
                while(cnt<=j){
                    tmp+=elements[idx];
                    ++idx;
                    ++cnt;
                    if(idx>=elements.length){
                        idx=0;
                    }
                }
                set.add(tmp);
            }
        }
        int answer = set.size();
        return answer;
    }
}