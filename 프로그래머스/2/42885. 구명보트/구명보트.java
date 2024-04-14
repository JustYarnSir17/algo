import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int idx1=0;
        int idx2=people.length-1;
        int cnt=0;
        while(idx1<=idx2){
            
        int tmp=0;
        tmp+=people[idx2--];
            
        if(tmp+people[idx1]<=limit){
                tmp+=people[idx1++];
            ++cnt;
            
        }
        else{
                ++cnt;
        }
            
            
        }
        return cnt;
    }
}