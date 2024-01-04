import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer>list = new ArrayList<>();
        int answer = 0;
        
        for(int i=0;i<tangerine.length;i++){
            if(map.containsKey(tangerine[i])){
                map.replace(tangerine[i],map.get(tangerine[i])+1);
            }
            else{
                map.put(tangerine[i],1);
            }
        }
        
        map.forEach((key,value)->{
            list.add(value);
        });
        Collections.sort(list);
        Collections.reverse(list);
        int cnt=0;
        while(cnt<k){
            for(int i=0;i<list.size();i++){
                cnt+=list.get(i);
                ++answer;
                if(cnt>=k){
                    break;
                }
            }
        }
        return answer;
    }
}