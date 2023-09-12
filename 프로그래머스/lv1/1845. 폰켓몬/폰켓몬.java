import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                map.replace(nums[i],map.get(nums[i])+1);
            }
            
        }
        int size = nums.length/2;
        
        int answer = 0;
        if(map.size()<=size){
            answer= map.size();
        }
        else{
            answer=size;
        }
        return answer;
    }
}